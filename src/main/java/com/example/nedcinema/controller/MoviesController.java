package com.example.nedcinema.controller;

import com.example.nedcinema.entity.Movies;
import com.example.nedcinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/")
    public Movies addMovie(@RequestBody Movies movie) {

        return movieService.addMovie(movie);
    }

    @PutMapping("/{movieId}")
    public Movies updateMovie(@PathVariable int movieId, @RequestBody Movies movie) {
        return movieService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);
    }

    @GetMapping("/{movieId}")
    public Movies getMovie(@PathVariable int movieId) {
        return movieService.getMovie(movieId);
    }

    @GetMapping("")
    public List<Movies> getAllMovies() {
        return movieService.getAllMovies();
    }
}
