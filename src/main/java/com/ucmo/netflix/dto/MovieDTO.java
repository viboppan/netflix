package com.ucmo.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private String id;
    private String title;
    private String type;
    private String description;
    private Integer release_year;
    private String age_certification;
    private Integer runtime;
    private List<String> genres;
    private List<String> production_countries;
    private Double imdb_score;

}
