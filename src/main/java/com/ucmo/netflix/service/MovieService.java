package com.ucmo.netflix.service;

import com.ucmo.netflix.dto.MovieDTO;
import com.ucmo.netflix.model.MovieDocument;

import java.util.List;
import java.util.Map;

public interface MovieService {

    List<MovieDocument> findAll();
    int deleteById(String title);

    int updateByTitle(String title, Map<Object, Object> data);

    String addMovie(MovieDTO movieDTO);
}
