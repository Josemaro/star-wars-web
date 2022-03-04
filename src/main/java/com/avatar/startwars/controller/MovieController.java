package com.avatar.startwars.controller;

import java.util.List;

import com.avatar.startwars.model.Movie;
import com.avatar.startwars.model.People;
import com.avatar.startwars.model.ResponsePageable.FilmList;
import com.avatar.startwars.service.PeopleService;
import com.avatar.startwars.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    FilmService filmService;

    @Autowired
    PeopleService peopleService;

    @GetMapping(value = "/{id}")
    public String buscarPelicula(@PathVariable("id") String id, Model model) throws Exception {

        Movie movie = filmService.getMovie(null,id);
        List<People> people = peopleService.getAllPeople(movie.characters);
        model.addAttribute("movie", movie);
        model.addAttribute("people", people);
        return "movie";
    }

    @GetMapping
    public String verFilms(Model model) throws Exception {

        FilmList films = filmService.getFilms();
        List<Movie> movies = films.getResults();
        model.addAttribute("films", films);
        model.addAttribute("movies", movies);
        return "films";
    }
}
