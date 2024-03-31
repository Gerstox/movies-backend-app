package com.learning.movies.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.movies.document.MovieDocument;
import com.learning.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDocument>> getAll() {
        return new ResponseEntity<List<MovieDocument>>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<MovieDocument>> getByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<MovieDocument>>(movieService.getByImdbId(imdbId), HttpStatus.OK);
    }

}
