package com.avatar.startwars.service;

import java.util.List;
import java.util.stream.Collectors;

import com.avatar.startwars.model.People;
import com.avatar.startwars.model.ResponsePageable.PeoplePageable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PeopleService {
    RestTemplate response = new RestTemplate();
    // https://swapi.dev/api/people/1/
    UriComponents uriPeople = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/people/")
            .build();
    /// api/people/?search=r2

    public List<People> getAllPeople(List<String> characters) {
        return characters.stream().map(
                (p) -> getPeopleByUrl(p, null)).collect(Collectors.toList());
    }

    public People getPeopleByUrl(String url, String id) {
        ResponseEntity<People> entity;
        if (id == null) {
            entity = response.getForEntity(url, People.class);
        } else {
            entity = response.getForEntity(uriPeople.toUriString() + id, People.class);
        }
        People people = People.builder()
                .name(entity.getBody().getName())
                .height(entity.getBody().getHeight())
                .mass(entity.getBody().getMass())
                .hair_color(entity.getBody().getHair_color())
                .skin_color(entity.getBody().getSkin_color())
                .eye_color(entity.getBody().getEye_color())
                .birth_year(entity.getBody().getBirth_year())
                .gender(entity.getBody().getGender())
                .homeworld(entity.getBody().getHomeworld())
                .films(entity.getBody().getFilms())
                .vehicles(entity.getBody().getVehicles())
                .starships(entity.getBody().getStarships())
                .edited(entity.getBody().getEdited())
                .url(entity.getBody().getUrl())
                .build();
        return people;
    }

    public PeoplePageable getPeoplePageable(String page) {
        ResponseEntity<PeoplePageable> entity = response.getForEntity(uriPeople.toUriString() + "?page=" + page,
                PeoplePageable.class);
        PeoplePageable pp = new PeoplePageable();
        pp.setCount(entity.getBody().getCount());
        pp.setNext(entity.getBody().getNext());
        pp.setPrevious(entity.getBody().getPrevious());
        pp.setResults(entity.getBody().getResults());

        return pp;
    }

    public PeoplePageable search(String name){
        ResponseEntity<PeoplePageable> entity = response.getForEntity(uriPeople.toUriString() + "?search=" + name,
        PeoplePageable.class);
        PeoplePageable pp = new PeoplePageable();
        pp.setCount(entity.getBody().getCount());
        pp.setNext(entity.getBody().getNext());
        pp.setPrevious(entity.getBody().getPrevious());
        pp.setResults(entity.getBody().getResults());
        return pp;
    }
}
