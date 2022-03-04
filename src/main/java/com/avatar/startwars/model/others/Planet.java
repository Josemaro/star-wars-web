package com.avatar.startwars.model.others;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    public String climate;
    public String created;
    public String diameter;
    public String edited;
    public List<String> films;
    public String gravity;
    public String name;
    public String orbital_period;
    public String population;
    public List<String> residents;
    public int rotation_period;
    public String surface_water;
    public String terrain;
    public String url;
}
