package com.avatar.startwars.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmList {
    private int count;
    private ArrayList<Movie> results;
    private String previous;
    private String next;
}
