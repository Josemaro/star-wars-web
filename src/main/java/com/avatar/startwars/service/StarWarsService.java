package com.avatar.startwars.service;

import java.util.List;
import java.util.stream.Collectors;

import com.avatar.startwars.model.Movie;
import com.avatar.startwars.model.People;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StarWarsService {
    RestTemplate response = new RestTemplate();
    // SWAPI
    // https://swapi.dev/

    // https://swapi.dev/api/films/1
    UriComponents uriFilms = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/films/")
            .build();

    // https://swapi.dev/api/people/1/
    UriComponents uriPeople = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/people/")
            .build();

    public Movie getMovie(String id) {
        ResponseEntity<Movie> entity = response.getForEntity(uriFilms.toUriString() + id, Movie.class);
        Movie movie = Movie.builder()
                .title(entity.getBody().getTitle())
                .episode_id(entity.getBody().getEpisode_id())
                .opening_crawl(entity.getBody().getOpening_crawl())
                .director(entity.getBody().getDirector())
                .producer(entity.getBody().getProducer())
                .characters(entity.getBody().getCharacters())
                .planets(entity.getBody().getPlanets())
                .starships(entity.getBody().getStarships())
                .vehicles(entity.getBody().getVehicles())
                .species(entity.getBody().getSpecies())
                .created(entity.getBody().getCreated())
                .edited(entity.getBody().getEdited())
                .url(entity.getBody().getUrl())
                // .people(getAllPeople(entity.getBody().getCharacters()))
                .build();
        
        log.info("{}", movie);
        return movie;
    }

    public List<People> getAllPeople(List<String> characters) {
        return characters.stream().map(
                (p) -> getPeopleByUnit(p)).collect(Collectors.toList());
    }

    public People getPeopleByUnit(String url) {
        ResponseEntity<People> entity = response.getForEntity(url, People.class);
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
}
