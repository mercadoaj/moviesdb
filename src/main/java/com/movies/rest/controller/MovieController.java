package com.movies.rest.controller;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.ModelMapper;
import com.movies.rest.entity.Movie;
import com.movies.rest.dto.MovieDTO;
import com.movies.rest.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



/**
* The MovieController class defines the implementation of the API endpoints operations.
*
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

/*
* All endpoints are mapped at '/movies' and all responses is a ResponseEntity.
*/
@RestController 
@RequestMapping(value = "/movies",
  produces = MediaType.APPLICATION_JSON_VALUE) 
@Api(description = "Set of endpoints for getting Movie data.")
public class MovieController implements MovieOperations{

	@Autowired
	private MovieService movieService;


	@Autowired
  ModelMapper modelMapper; 

  /**
  * Gets information about a specific movie.
  * 
  * @param id id of the movie.
  * @return the movie details.
  */
  @Override
  @ApiOperation(value = "Gets information about a specific movie.",
    notes = "",
    response = Movie.class)
  public ResponseEntity<Movie> findById( @ApiParam("Id of the movie.")  @PathVariable("id") Long id) {

    Movie movie = movieService.findById(id).get();
    return new ResponseEntity(movie,HttpStatus.OK);
  }

  /**
  * Gets all the movies.
  * 
  * @param page the page index.
  * @param size the number of rows in each page.
  * @param sort the property by which the entries are to be sorted.
  * @return all the movies.
  */
  @Override
  @ApiOperation(value = "Gets all the movies.",
    notes = "Lorem Ipsum",
    response = Movie.class,
    responseContainer = "List")
  public ResponseEntity<MovieDTO> findAll(
        @ApiParam("The page of the returned result. The page count starts at 0.") @RequestParam(defaultValue = "0", required = false) Integer page, 
        @ApiParam("The number of rows to be returned per page.") @RequestParam(defaultValue = "10", required = false) Integer size,
        @ApiParam("The property for which the page is sorted.") @RequestParam(defaultValue = "title", required = false) String sort) {

        List<MovieDTO> movies = movieService.findAll(page, size,sort)
        .stream()
        .map(this::convertToDTO) // we need to convert this because we need to return a DTO inested of an entity.
        .collect(Collectors.toList());

        return new ResponseEntity(movies,HttpStatus.OK);

  }



  /**
  * Converts an entity to a dto.
  *
  * @param movie the movie entity.
  * @return the dto of the movie.
  */
  private MovieDTO convertToDTO(Movie movie) { 

    modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE);
    MovieDTO movieDTO = modelMapper
            .map(movie, MovieDTO.class);  
    return movieDTO;
  }


  

}