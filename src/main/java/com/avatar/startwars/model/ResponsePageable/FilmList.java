package com.avatar.startwars.model.ResponsePageable;

import java.util.List;

import com.avatar.startwars.model.Movie;

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
    private List<Movie> results;
    private String previous;
    private String next;
}
