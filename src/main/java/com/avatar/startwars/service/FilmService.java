package com.avatar.startwars.service;

import java.util.List;
import java.util.stream.Collectors;

import com.avatar.startwars.model.Movie;
import com.avatar.startwars.model.ResponsePageable.FilmList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FilmService {
    RestTemplate response = new RestTemplate();
    // SWAPI
    // https://swapi.dev/

    // https://swapi.dev/api/films/1
    UriComponents uriFilms = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/films/")
            .build();

    public FilmList getFilms() {
        ResponseEntity<FilmList> entity = response.getForEntity(uriFilms.toUriString(), FilmList.class);
        FilmList films = FilmList.builder()
                .results(entity.getBody().getResults())
                .count(entity.getBody().getCount())
                .build();
        // log.info("{}", films);
        return films;
    }

    public List<Movie> getAllFilms(List<String> films) {
        return films.stream().map(
                (p) -> getMovie(p, null)).collect(Collectors.toList());
    }

    public Movie getMovie(String url, String id) {
        ResponseEntity<Movie> entity;
        if (id == null) {
            entity = response.getForEntity(url, Movie.class);
        } else {
            entity = response.getForEntity(uriFilms.toUriString() + id, Movie.class);
        }
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


}
