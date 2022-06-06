package com.demo.continuoustests.repositories;

import com.demo.continuoustests.models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Movie> {
}
