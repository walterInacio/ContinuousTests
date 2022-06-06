package com.demo.continuoustests.integration.controller;

import com.demo.continuoustests.models.Movie;
import com.demo.continuoustests.repositories.MoviesRepository;
import com.demo.continuoustests.unit.utils.MockFactoryMovies;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntegrationTests {

    @MockBean
    MoviesRepository repository;

    @LocalServerPort
    private Integer appPort;

    @BeforeEach
    void setup() {
        port = appPort;
    }

    @Test
    void testGetAllMoviesControllerService() {

        //prepare
        Movie morbius = MockFactoryMovies.generateMovie("Morbius", "Marvel's movie");
        List<Movie> movies = new ArrayList<>(List.of(morbius));
        Mockito.when(repository.findAll()).thenReturn(movies);

        //act
        Movie[] list =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON).
                when()
                    .get("/movies").
                then()
                    .statusCode(HttpStatus.OK.value())
                    .extract().body().as(new TypeRef<>() {});

        //assert
        assertNotNull(list);
    }
}
