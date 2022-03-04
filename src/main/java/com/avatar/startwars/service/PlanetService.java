package com.avatar.startwars.service;

import java.util.List;
import java.util.stream.Collectors;

import com.avatar.startwars.model.People;
import com.avatar.startwars.model.ResponsePageable.PlanetPageable;
import com.avatar.startwars.model.others.Planet;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlanetService {
    RestTemplate response = new RestTemplate();
    // https://swapi.dev/api/people/1/
    UriComponents uriPeople = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/planets/")
            .build();

    public List<Planet> getAllPlanets(List<String> planets) {
        return planets.stream().map(
                (p) -> getPlanetByUrl(p, null)).collect(Collectors.toList());
    }

    public Planet getPlanetByUrl(String url, String id) {
        ResponseEntity<Planet> entity;
        if (id == null) {
            entity = response.getForEntity(url, Planet.class);
        } else {
            entity = response.getForEntity(uriPeople.toUriString() + id, Planet.class);
        }
        Planet planet = Planet.builder()
                .name(entity.getBody().getName())
                .climate(entity.getBody().getClimate())
                .diameter(entity.getBody().getDiameter())
                .edited(entity.getBody().getEdited())
                .films(entity.getBody().getFilms())
                .gravity(entity.getBody().getGravity())
                .orbital_period(entity.getBody().getOrbital_period())
                .population(entity.getBody().getPopulation())
                .residents(entity.getBody().getResidents())
                .surface_water(entity.getBody().getSurface_water())
                .terrain(entity.getBody().getTerrain())
                .edited(entity.getBody().getEdited())
                .url(entity.getBody().getUrl())
                .build();
        return planet;
    }

    public PlanetPageable getPlanetPageable(String page) {
        ResponseEntity<PlanetPageable> entity = response.getForEntity(uriPeople.toUriString() + "?page=" + page,
                PlanetPageable.class);
        PlanetPageable pp = new PlanetPageable();
        pp.setCount(entity.getBody().getCount());
        pp.setNext(entity.getBody().getNext());
        pp.setPrevious(entity.getBody().getPrevious());
        pp.setResults(entity.getBody().getResults());

        return pp;
    }

    public PlanetPageable search(String name) {
        ResponseEntity<PlanetPageable> entity = response.getForEntity(uriPeople.toUriString() + "?search=" + name,
                PlanetPageable.class);
        PlanetPageable pp = new PlanetPageable();
        pp.setCount(entity.getBody().getCount());
        pp.setNext(entity.getBody().getNext());
        pp.setPrevious(entity.getBody().getPrevious());
        pp.setResults(entity.getBody().getResults());
        return pp;
    }

}
