package com.ucmo.netflix.resource;


import com.ucmo.netflix.dto.MovieDTO;
import com.ucmo.netflix.mapper.Mapper;
import com.ucmo.netflix.model.MovieDocument;
import com.ucmo.netflix.repository.MovieRepository;
import com.ucmo.netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    Mapper mapper;


    @PostMapping("/api")
    public String addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @PatchMapping("/api/{title}")
    public String updateMovie(@PathVariable String title, @RequestBody Map<Object, Object> data) {
        int result = movieService.updateByTitle(title, data);
        if (result == 1)
            return "updated successfully";
        else if(result == 2)
            return "movie not found";
        else
            return "invalid data";
    }


    @DeleteMapping("/api/{title}")
    public String deleteMovie(@PathVariable String title) {
        int result = movieService.deleteById(title);
        if (result == 1)
            return "deleted successfully";
        else
            return "movie not found";
    }

    @GetMapping("/api")
    public List<MovieDTO> getMovies() {

        List<MovieDocument> movieList = movieService.findAll();
        movieList.stream().forEach(movie -> System.out.println(movie.getRuntime()));
        return movieList.stream().map(movieEntity -> mapper.entityToDTOMapper(movieEntity))
                .collect(Collectors.toList());
    }
}
