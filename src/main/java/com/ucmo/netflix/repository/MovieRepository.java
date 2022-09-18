package com.ucmo.netflix.repository;

import com.ucmo.netflix.model.MovieDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends MongoRepository<MovieDocument, String> {

    /*List<MovieEntity> findByTitle(@Param("title") String name);*/

    List<MovieDocument> findAll();

    @Override
    Optional<MovieDocument> findById(String s);

    @Override
    void deleteById(String s);

}
