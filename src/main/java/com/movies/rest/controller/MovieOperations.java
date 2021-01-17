package com.movies.rest.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.movies.rest.entity.Movie;
import org.springframework.http.ResponseEntity;

/**
* The MovieOperations interface defines the operations for the API endpoints.
*
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

/**
* All endpoints is mapped at '/movies'
*/
@RequestMapping("/movies")
public interface MovieOperations {

	/**
	* Gets a specific information about a movie. 
	*/
    @GetMapping("/{id}")
    ResponseEntity findById(Long id);

	/**
	* Gets all the movies.
	*/
    @GetMapping(value="/")
    ResponseEntity findAll(Integer page, Integer size, String sort);


}