
package com.movies.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
/**
* The Movie entity class. This class represents the table in the database. All entries from this table were taken from 
*  @see <a href="https://www.imdb.com/search/title/?year=2020,2020&title_type=feature&sort=num_votes,desc">IMDB</a> at the time of writing.
*
*  @author Arneil John Mercado
*  @since   2020-01-16 
*/

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="the database generated movie id.")
    private Long id;

    @Column(columnDefinition="TEXT")
    @ApiModelProperty(notes="The overview of the movie.")
    private String overview;

    @ApiModelProperty(notes="The title of the movie.")
    private String title;

    @ApiModelProperty(notes="The url of the poster of the movie.")
    private String poster;

    @ApiModelProperty(notes="The # of votes inccured by the movie.")
    private long voteAverage;

    @ApiModelProperty(notes="The release date of the movie.")
    private LocalDate releaseDate;

    public Movie(String title, String overview, String poster, long voteAverage, LocalDate releaseDate){
        this.title = title;
        this.overview = overview;
        this.poster = poster;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }
    protected Movie(){}

    public Long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getOverview(){
        return this.overview;
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

    public void setId(Long id){
        this.title = title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setOverview(String overview){
        this.overview = overview;
    }
    public void setPoster(String poster){
        this.overview = overview;
    }
    public void setVoteAverage(long voteAverage){
        this.voteAverage = voteAverage;
    }
    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Movie))
            return false;
        Movie movie = (Movie) o;
        return Objects.equals(this.id, movie.getId());
    }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.releaseDate);
  }

}

