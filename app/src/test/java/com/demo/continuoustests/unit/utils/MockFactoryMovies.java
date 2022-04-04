package com.demo.continuoustests.unit.utils;

import com.demo.continuoustests.models.Movie;
import com.demo.continuoustests.models.MovieId;

import java.util.Random;

public class MockFactoryMovies {

    public static Movie generateMovie(String name, String desc) {
        MovieId movieId = new MovieId();
        movieId.setIdMovie(new Random().nextInt());
        return Movie.builder().id(movieId).name(name).description(desc).build();
    }
}
