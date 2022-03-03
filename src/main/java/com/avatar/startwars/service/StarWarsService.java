package com.avatar.startwars.service;

import com.avatar.startwars.model.Movie;

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

    // https://swapi.dev/api/films/
    UriComponents uriFilms = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/films/")
            .build();

    public Movie getMovie(String id){
        ResponseEntity<Movie> entity = response.getForEntity(uriFilms.toUriString()+id,Movie.class);
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
            .build();
        log.info("{}",movie);
        return movie;
    }
}
