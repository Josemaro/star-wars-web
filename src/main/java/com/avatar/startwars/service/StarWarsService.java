package com.avatar.startwars.service;

import com.avatar.startwars.model.Movie;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class StarWarsService {
    RestTemplate template = new RestTemplate();
    // SWAPI
    // https://swapi.dev/

    // https://swapi.dev/api/films/
    UriComponents uriFilms = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("swapi.dev/")
            .path("api/films/")
            .build();
}
