package com.movie.resource;

import com.movie.document.Movies;
import com.movie.repository.MovieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class MoviesResource {

	private MovieRepository userRepository;

	public MoviesResource(MovieRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/all")
	public List<Movies> getAll() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addMovie(@RequestBody Movies user) {
		try {
			userRepository.save(user);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateMovie(@RequestBody Movies user) {
		try {
			userRepository.save(user);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			userRepository.delete(id);
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}
}
