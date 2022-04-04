package com.demo.continuoustests.unit.services;

import com.demo.continuoustests.models.Movie;
import com.demo.continuoustests.repositories.MoviesRepository;
import com.demo.continuoustests.services.MoviesService;
import com.demo.continuoustests.unit.utils.MockFactoryMovies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MovieServicesTests {

    private static List<Movie> movies;

    @Mock
    private MoviesRepository moviesRepository;

    @InjectMocks
    private MoviesService moviesService;

    @BeforeAll
    static void prepare() {
        //Creating new movies to add in a movie list
        Movie spiderMan = MockFactoryMovies.generateMovie("Spider Man","Piter Parker's movie");
        Movie interstellar = MockFactoryMovies.generateMovie("Interstellar", "Planetary movies");

        //Movie list add
        movies = new ArrayList<>(Arrays.asList(spiderMan, interstellar));
    }

    @Test
    @DisplayName("Service - Get All Movies")
    void getAllMoviesTest() {
        //prepare
        Mockito.when(moviesRepository.findAll()).thenReturn(movies);

        //act
        List<Movie> movieList = moviesService.getAllMovies();

        //assert
        Assertions.assertEquals(movieList, movies);
    }
}

