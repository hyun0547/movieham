package com.movieHam.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.movieHam.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovieList(MovieSearch movieSearch) {

        List<Movie> movieList = movieRepository.findList(movieSearch);
        
        return movieList;
    }

    @Override
    public Movie getMovie(Integer id) {
        Optional<Movie> test = movieRepository.findById(id);
        return test.orElse(null);
    }

}
