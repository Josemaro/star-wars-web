package com.avatar.startwars.model.ResponsePageable;

import java.util.List;

import com.avatar.startwars.model.People;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeoplePageable {
    private int count;
    private String next;
    private String previous;
    private List<People> results;
}
