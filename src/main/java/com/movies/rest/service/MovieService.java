package com.movies.rest.service;

import java.util.List;
import java.util.Optional;
import com.movies.rest.entity.Movie;

/**
* The MovieService interface defines the database operations for the service.
*
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

public interface MovieService {

	/**
 	* Fetches all the movies. 
 	*
 	*	@param pageNo the index of the page. 
 	*	@param pageSize the number of rows of each page. 
 	*	@param sortBy the property of the Movie entity by which the queried rows are to be sorted.
 	* 
 	*	@return A list of movies
 	*/
    public List<Movie> findAll(Integer pageNo, Integer pageSize, String sortBy);


	/**
 	* 	Fetches a movie using the id. 
 	*
 	*	@param id id of the movie
 	*
 	*	@return the movie details
 	*/
    public Optional<Movie> findById(Long id);

}