package com.demo.continuoustests.services;

import com.demo.continuoustests.models.Movie;
import com.demo.continuoustests.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAllMovies() {
        System.out.println("Init Service endpoint - get all movies");
        List<Movie> movies = moviesRepository.findAll();

        if(movies.isEmpty()) {
            return new ArrayList<>();
        }

        System.out.println("End Service endpoint - get all movies");
        return movies;
    }
}
