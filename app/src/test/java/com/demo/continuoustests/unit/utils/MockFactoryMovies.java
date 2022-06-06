package com.demo.continuoustests.unit.utils;

import com.demo.continuoustests.models.Movie;

import java.util.Random;

public class MockFactoryMovies {

    public static Movie generateMovie(String name, String desc) {
        return Movie.builder().id(new Random().nextLong()).name(name).description(desc).build();
    }
}
