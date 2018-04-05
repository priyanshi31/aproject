package com.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.document.Movies;

public interface MovieRepository extends MongoRepository<Movies, Integer> {
}
