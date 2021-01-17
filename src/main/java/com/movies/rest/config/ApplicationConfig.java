package com.movies.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* The ApplicationConfig class is used for defining configurations for the application.
* 
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

@Configuration
public class ApplicationConfig {

	/**
	*	Creates a ModelMapper instance that is used for mapping Entities into a Data Transfer Object. 
	* 	@return the ModelMapper instance.
	*/
   @Bean
   public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
   }

}