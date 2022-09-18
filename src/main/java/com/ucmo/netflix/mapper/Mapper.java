package com.ucmo.netflix.mapper;

import com.ucmo.netflix.dto.MovieDTO;
import com.ucmo.netflix.model.MovieDocument;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {


    public MovieDocument dtoToEntityMapper(MovieDTO movieDTO){

        //mapper to convert DTO provided in api request to Document which is mapped to Collection netflix

        MovieDocument movieDocument = new MovieDocument();
        movieDocument.setId(movieDTO.getId());
        movieDocument.setTitle(movieDTO.getTitle());
        movieDocument.setType(movieDTO.getType());
        movieDocument.setDescription(movieDTO.getDescription());
        movieDocument.setRelease_year(movieDTO.getRelease_year());
        movieDocument.setAge_certification(movieDTO.getTitle());
        movieDocument.setRuntime(movieDTO.getRuntime());
        movieDocument.setProduction_countries(movieDTO.getProduction_countries());
        movieDocument.setGenres(movieDTO.getGenres());
        movieDocument.setImdb_score(movieDTO.getImdb_score());
        return movieDocument;
    }

    public MovieDTO entityToDTOMapper(MovieDocument movieDocument){

        //mapper to convert Document to a DTO

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieDocument.getId());
        movieDTO.setTitle(movieDocument.getTitle());
        movieDTO.setType(movieDocument.getType());
        movieDTO.setDescription(movieDocument.getDescription());
        movieDTO.setRelease_year(movieDocument.getRelease_year());
        movieDTO.setAge_certification(movieDocument.getTitle());
        movieDTO.setRuntime(movieDocument.getRuntime());
        movieDTO.setProduction_countries(movieDocument.getProduction_countries());
        movieDTO.setGenres(movieDocument.getGenres());
        movieDTO.setImdb_score(movieDocument.getImdb_score());
        return movieDTO;
    }
}
