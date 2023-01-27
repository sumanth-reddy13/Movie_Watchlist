package com.avengers.MovieDirectorList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String add_movie_director_pair(String movieName, String name) {
        return movieRepository.add_movie_director_pair(movieName, name);
    }

    public Movie getMovie(String name) {
        return movieRepository.getMovie(name);
    }

    public Director getDirector(String name) {
        return movieRepository.getDirector(name);
    }

    public List<String> get_movies_by_director_name(String name) {
        return movieRepository.get_movies_by_director_name(name);
    }

    public List<String> get_all_Movies() {
        return movieRepository.get_all_Movies();
    }

    public String delete_director_by_name(String name) {
        return movieRepository.delete_director_by_name(name);
    }

    public String delete_all_directors() {
        return movieRepository.delete_all_directors();
    }
}
