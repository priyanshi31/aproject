package com.movie.config;


import com.movie.repository.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MovieRepository.class)
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(MovieRepository userRepository) {
    	return null;
    }
}
