package com.learning.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.movies.document.MovieDocument;
import com.learning.movies.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDocument> getAll() {
        return movieRepository.findAll();
    }

    public Optional<MovieDocument> getByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
