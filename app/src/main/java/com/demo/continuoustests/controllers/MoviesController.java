package com.demo.continuoustests.controllers;

import com.demo.continuoustests.models.Movie;
import com.demo.continuoustests.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(moviesService.getAllMovies());
    }
}
