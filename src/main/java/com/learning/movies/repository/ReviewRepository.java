package com.learning.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.movies.document.ReviewDocument;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewDocument, ObjectId> {

}