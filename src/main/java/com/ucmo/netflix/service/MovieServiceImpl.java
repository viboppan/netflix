package com.ucmo.netflix.service;

import com.ucmo.netflix.dto.MovieDTO;
import com.ucmo.netflix.mapper.Mapper;
import com.ucmo.netflix.model.MovieDocument;
import com.ucmo.netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    /* Service class where data is validated and business logic is added*/

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private Mapper mapper;

    public String addMovie(MovieDTO movieDTO) {
        String message;
        if (validateMovie(movieDTO)) {
            MovieDocument movieDocument = movieRepository.save(mapper.dtoToEntityMapper(movieDTO));
            message = movieDocument.get_id() != null ? "Added Successfully" : "Error occurred while adding";
            return message;
        } else
            return "Invalid data";
    }

    @Override
    public List<MovieDocument> findAll() {
        System.out.println("in Movie service impl");
        return movieRepository.findAll();
    }

    @Override
    public int deleteById(String title) {
        String id;
        List<MovieDocument> movieEntities = movieRepository.findAll();
        Optional<MovieDocument> temp = movieEntities.stream().
                filter(movieEntity -> movieEntity.getTitle() != null &&
                        movieEntity.getTitle().equals(title)).findFirst();
        if (temp.isPresent()) {
            id = temp.get().get_id();
            movieRepository.deleteById(id);
            return 1;
        }
        return 0;

    }

    public int updateByTitle(String title, Map<Object, Object> data) {

        if(!validatePatchData(data))
            return 0;
        List<MovieDocument> movieEntities = this.findAll();
        Optional<MovieDocument> temp = movieEntities.stream().
                filter(movieEntity -> movieEntity.getTitle() != null &&
                        movieEntity.getTitle().equals(title)).findFirst();
        if (temp.isPresent()) {
            MovieDocument movieDocument = temp.get();
            movieDocument.setTitle((String) data.get("title"));
            movieDocument.setDescription((String) data.get("description"));
            movieDocument.setImdb_score((data.get("imdb_score") )instanceof Integer ?
                    Integer.valueOf(data.get("imdb_score").toString())
                    : Double.parseDouble(data.get("imdb_score").toString()));
            movieRepository.save(movieDocument);
            return 1;
        }
        return 2;
    }

    //validate if the id and title exists and if imdb score exists it is between 0 and 10
    boolean validateMovie(MovieDTO movieDTO) {
        boolean flag = true;
        if (movieDTO.getId() == null || movieDTO.getTitle() == null ){
            flag = false;
        }
        if(movieDTO.getImdb_score()!=null){
            if (movieDTO.getImdb_score()<0.0 && movieDTO.getImdb_score()>10.0){
             flag = false;
            }
        }
        return flag;
    }

    //validate if the keys provided in request matches the fields
    boolean validatePatchData(Map<Object,Object> data){
        boolean imdb=true;
        Iterator<Map.Entry<Object,Object>> itr = data.entrySet().iterator();
        List<String> keys = Arrays.asList("title","description","imdb_score");
        while (itr.hasNext()){
            if(! keys.contains( itr.next().getKey() ) ){
                return false;
            }
        }
        if(data.get("imdb_score")!=null)
            imdb = validateImdbScore((data.get("imdb_score") )instanceof Integer ?
                    Integer.valueOf(data.get("imdb_score").toString())
                    : Double.parseDouble(data.get("imdb_score").toString()));
        if(data.get("title")==null){
            return false;
        }
        return imdb;
    }

    boolean validateImdbScore(Double d){
        if (d<0.0 || d>10.0)
            return false;
        return true;
    }
}
