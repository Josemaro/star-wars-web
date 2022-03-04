package com.avatar.startwars.controller;

import java.util.List;

import com.avatar.startwars.model.Movie;
import com.avatar.startwars.model.People;
import com.avatar.startwars.model.ResponsePageable.PeoplePageable;
import com.avatar.startwars.model.ResponsePageable.PlanetPageable;
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
@RequestMapping("/planets")

public class PlanetsController {

    @Autowired
    PlanetService planetService;


    @GetMapping(value = "/{id}")
    public String searchPlanet(@PathVariable("id") String id, Model model) throws Exception {
        Planet planet = planetService.getPlanetByUrl(null, id);
        model.addAttribute("planet", planet);
        return "planet";
    }

    @GetMapping(value = "/search")
    public String searchPlanetByName(@RequestParam(value = "name", defaultValue = "Luke", required = true) String name, Model model) throws Exception {
        PlanetPageable pageable = planetService.search(name);
        List<Planet> planets = pageable.getResults();
        model.addAttribute("pageable", pageable);
        model.addAttribute("planets", planets);
        return "planets";
    }


    @GetMapping
    public String planetsPageable(@RequestParam(value = "page", defaultValue = "1", required = true) String page,
            Model model) {
        PlanetPageable pageable = planetService.getPlanetPageable(page);
        List<Planet> planets = pageable.getResults();
        model.addAttribute("pageable", pageable);
        model.addAttribute("planets", planets);
        return "planets";
    }
}
