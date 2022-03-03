package com.avatar.startwars.model;

import java.util.List;

import lombok.Data;

@Data
public class People {
    public String name;
    public String height; 
    public String mass;
    public String hair_color; 
    public String skin_color;
    public String eye_color; 
    public String birth_year;
    public String gender; 
    public String homeworld; 
    public List<String> films;
    public List<String> species; 
    public List<String> vehicles;
    public List<String> starships;
    public String created; 
    public String edited;
    public String url;
}
