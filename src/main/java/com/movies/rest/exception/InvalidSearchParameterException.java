package com.movies.rest.exception;
/**
* The InvalidSearchParameterException class is the exception created when wrong search parameters are used in calling operations to the database.
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/
public class InvalidSearchParameterException extends RuntimeException {

    public InvalidSearchParameterException(String param) {
        super("Invalid Search Parameters. " + param);
    }

}