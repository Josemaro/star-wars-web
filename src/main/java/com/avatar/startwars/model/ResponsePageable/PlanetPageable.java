package com.avatar.startwars.model.ResponsePageable;

import java.util.List;

import com.avatar.startwars.model.others.Planet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetPageable {
    private int count;
    private List<Planet> results;
    private String previous;
    private String next;
}
