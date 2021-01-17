package com.movies.rest.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.movies.rest.repository.MovieRepository;
import com.movies.rest.entity.Movie;
import com.movies.rest.exception.MovieNotFoundException;
import com.movies.rest.exception.InvalidSearchParameterException;
import org.springframework.data.mapping.PropertyReferenceException;



/**
* The DefaultMovieService class implements the operations for the MovieService.
*
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/
@Service
public class DefaultMovieService implements MovieService {

    /**
    *  Creates a MovieRepository instance used to make calls to the database.
    */
    @Autowired
    private final MovieRepository movieRepository;

    public DefaultMovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll(Integer pageNo, Integer pageSize, String sortBy){


        try{
            // we sorround it with a try catch since there is a possiblity for the user to pass invalid parameters.
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

            Page<Movie> pagedResult = movieRepository.findAll(paging);

             if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<Movie>();
            }
        
        }catch(PropertyReferenceException e){
            //this exception is fired when the value for property used for sorting the retrieved rows does not exist.
             throw new InvalidSearchParameterException("Property '"+sortBy+"' does not exist.");

        }catch(IllegalArgumentException e){
            //this exception is fired when the value  pageNo or pageSize parameter is not an integer or is less than 0.
            throw new InvalidSearchParameterException(e.getMessage());
            
        }
        
    }

    /**
    * Gets the details on a specific movie.
    *
    * @param id id of the movie.
    * @return the specific movie.
    */
    @Override
    public Optional<Movie> findById(Long id){
        Optional<Movie> movie = movieRepository.findById(id);

        if (!movie.isPresent()) 
            throw new MovieNotFoundException(id); //if a movie is not founc, an exception is thrown.
        
        return movie;
    }

}