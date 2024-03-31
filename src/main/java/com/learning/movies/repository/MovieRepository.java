package com.learning.movies.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.movies.document.MovieDocument;

@Repository
public interface MovieRepository extends MongoRepository<MovieDocument, ObjectId> {

    Optional<MovieDocument> findMovieByImdbId(String imbdID);

}
