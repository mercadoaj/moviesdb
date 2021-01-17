package com.movies.rest.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
* The ControllerAdvisor class provides the centralized handling of exceptions in the application.
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    /**
    * This exception handler is called when invalid search parameters are used in searching. 
    */
    @ExceptionHandler(InvalidSearchParameterException.class)
    public final ResponseEntity<CustomErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }


    /**
    * This exception handler is called when a movie is not found.
    */
    @ExceptionHandler(MovieNotFoundException.class)
    public final ResponseEntity<CustomErrorResponse> handleUserNotFoundException(Exception ex, WebRequest request) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}

