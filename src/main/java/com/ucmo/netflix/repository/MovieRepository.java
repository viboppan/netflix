package com.ucmo.netflix.repository;

import java.util.List;

import com.ucmo.netflix.dto.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByLastName(@Param("title") String name);

}
