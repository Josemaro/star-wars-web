package com.avatar.startwars.model;

import java.util.List;

import lombok.Data;

@Data
public class Movie {
    public String title;
    public String episode_id;
    public String opening_crawl;
    public String director;
    public String producer;
    public List<String> characters;
}
