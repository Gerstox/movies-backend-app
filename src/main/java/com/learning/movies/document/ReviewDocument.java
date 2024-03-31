package com.learning.movies.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDocument {

    @Id
    private ObjectId id;

    private String body;

    public ReviewDocument(String body) {
        this.body = body;
    }

}
