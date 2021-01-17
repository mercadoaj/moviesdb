package com.movies.rest.exception;

/**
* The MovieNotFoundException class is the exception created when a specific movie cannot be retrieved or is not found.
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super("Movie id not found : " + id);
    }

}