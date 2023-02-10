package com.movieHam.movie.service.mapper.moviePeople;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movieHam.movie.service.people.People;
import com.movieHam.movie.service.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Mapping table for Movie and People
 */

@Getter
@Setter
@NoArgsConstructor
@Entity(name= "tm_movie_people")
public class MoviePeople {

    public MoviePeople(Movie movie, People people){
        this.movie = movie;
        this.people = people;
        this.moviePeopleId = new BigInteger(String.valueOf(movie.getMovieId()) + String.valueOf(people.getPeopleId()));
    }

    @Id
    private BigInteger moviePeopleId;
    private Integer order;
    private String character;
    private String department;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "people_id")
    @JsonManagedReference
    private People people;

}
