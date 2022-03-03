package com.avatar.startwars.controller;

import java.util.List;

import com.avatar.startwars.model.Movie;
import com.avatar.startwars.model.People;
import com.avatar.startwars.service.StarWarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    StarWarsService service;

    @GetMapping(value = "/{id}")
    public String buscarPelicula(@PathVariable("id") String id,Model model) throws Exception {
        
        Movie movie = service.getMovie(id);
        List<People> people =  service.getAllPeople(movie.characters);
        model.addAttribute("movie",movie);
        model.addAttribute("people",people);

        // PokePage pp = service.getPokePage(offset,limit);
        // model.addAttribute("pokePage",pp);
        // ArrayList<Pokemon> pokelist = new ArrayList<Pokemon>();
        // for(Result r: pp.getResults()){
        //     pokelist.add(service.getPokemon(r.getName()));
        // }
        // model.addAttribute("pokelist",pokelist);
        return "movies";
    }
}
