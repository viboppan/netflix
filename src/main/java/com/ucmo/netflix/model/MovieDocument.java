package com.ucmo.netflix.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "netflix")
public class MovieDocument {

    @Id
    private String _id;
    private  String id;
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
