package com.learning.movies.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.movies.document.ReviewDocument;
import com.learning.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDocument> create(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<ReviewDocument>(
                reviewService.create(
                        payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }

}
