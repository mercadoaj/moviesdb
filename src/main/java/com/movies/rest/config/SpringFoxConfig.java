package com.movies.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;
import com.google.common.base.Predicates;
/**
* The SpringFoxConfig class is used for defining configuration for Swagger. 
* 
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

@Configuration
@EnableSwagger2
public class SpringFoxConfig {         

  /**
  * Creates a Docket instance that is used for documenting the api endpoints. 
  * The API endpoints can be found at @see <a href="localhost:9991/movies/swagger-ui.html">IMDB</a> 
  * 
  *  @return the API information
  */
    @Bean
    public Docket api() { 

    	Contact contact = new Contact(
               "Arneil John Mercado",
               "https://github.com/mercadoaj", 
               "arneiljohnm@gmail.com"
       );

    	ApiInfo apiInfo = new ApiInfo(
      	"MovieDB API endpoints documentation", 
     	"This page is created to document the api endpoints for the themoviedb service.", "1.0",
      	"http://www.appsdeveloperblof.com/service.html", contact, 
      	"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());

        return new Docket(DocumentationType.SWAGGER_2) 
       		.apiInfo(apiInfo)
          	.select()                                  
          	.apis(RequestHandlerSelectors.basePackage( "com.movies.rest" ))
            .paths(PathSelectors.any())  
            .paths(Predicates.not(PathSelectors.regex("/dto.*")))                                                             
          	.build();                                           
    }
}