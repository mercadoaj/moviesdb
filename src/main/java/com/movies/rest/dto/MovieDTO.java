package com.movies.rest.dto;

import java.time.LocalDate;

/**
* The Movie entity class Data Transfer Object. 
*
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

public class MovieDTO {

    private String title;
    private String poster;
    private long voteAverage;
    private LocalDate releaseDate;

    public String getTitle(){
        return this.title;
    }
    public String getPoster(){
        return this.poster;
    }
    public long getVoteAverage(){
        return this.voteAverage;
    }
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setVoteAverage(long voteAverage){
        this.voteAverage = voteAverage;
    }
    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setPoster(String poster){
        this.poster = poster;
    }


}

