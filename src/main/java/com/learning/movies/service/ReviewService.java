package com.learning.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.learning.movies.document.MovieDocument;
import com.learning.movies.document.ReviewDocument;
import com.learning.movies.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ReviewDocument create(String reviewBody, String imdbId) {
        ReviewDocument review = reviewRepository.insert(new ReviewDocument(reviewBody));

        mongoTemplate.update(MovieDocument.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

}
