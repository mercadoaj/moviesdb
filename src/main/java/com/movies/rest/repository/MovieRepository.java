package com.movies.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.movies.rest.entity.Movie;

/**
* The MovieRepository interface defines the database operations to be used by the implementing class.
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

}