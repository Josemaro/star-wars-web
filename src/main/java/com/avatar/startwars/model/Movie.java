package com.avatar.startwars.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    public String title;
    public int episode_id;
    public String opening_crawl;
    public String director;
    public String producer;
    public List<String> characters;
    public List<String> planets;
    public List<String> starships;
    public List<String> vehicles;
    public List<String> species;
    public String created;
    public String edited;
    public String url;
}
