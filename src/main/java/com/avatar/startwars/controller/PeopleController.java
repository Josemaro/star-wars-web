package com.avatar.startwars.controller;

import java.util.List;

import com.avatar.startwars.model.Movie;
import com.avatar.startwars.model.People;
import com.avatar.startwars.model.ResponsePageable.PeoplePageable;
import com.avatar.startwars.model.others.Planet;
import com.avatar.startwars.service.FilmService;
import com.avatar.startwars.service.PeopleService;
import com.avatar.startwars.service.PlanetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    FilmService filmService;

    @Autowired
    PeopleService peopleService;

    @Autowired
    PlanetService planetService;

    @GetMapping(value = "/{id}")
    public String searchCharacter(@PathVariable("id") String id, Model model) throws Exception {
        People character = peopleService.getPeopleByUrl(null, id);
        List<Movie> films = filmService.getAllFilms(character.films);
        Planet planet = planetService.getPlanetByUrl(character.homeworld,null);
        model.addAttribute("character", character);
        model.addAttribute("films", films);
        model.addAttribute("planet",planet);
        // model.addAttribute("films", films);
        // model.addAttribute("people", people);
        return "character";
    }

    @GetMapping
    public String peoplePageable(@RequestParam(value = "page", defaultValue = "1", required = true) String page,
            Model model) {
        PeoplePageable pageable = peopleService.getPeoplePageable(page);
        List<People> people = pageable.getResults();
        model.addAttribute("pageable", pageable);
        model.addAttribute("people", people);
        return "characters";
    }
    @GetMapping("/search")
    public String searchPeople(@RequestParam(value = "name", defaultValue = "Luke", required = true) String name,
            Model model) {
        PeoplePageable pageable = peopleService.search(name);
        List<People> people = pageable.getResults();
        model.addAttribute("pageable", pageable);
        model.addAttribute("people", people);
        return "characters";
    }
}
