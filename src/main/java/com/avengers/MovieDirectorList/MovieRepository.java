package com.avengers.MovieDirectorList;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    private Map<String, Movie> movieList;
    private Map<String, Director> directorList;
    private Map<String , List<String>> directorMoviesList;

    public MovieRepository() {
        this.movieList = new HashMap<>();
        this.directorList = new HashMap<>();
        this.directorMoviesList = new HashMap<>();
    }

    public String addMovie(Movie movie) {
        String name = movie.getName();
        movieList.put(name , movie);
        return "Movie added to the movies list";
    }

    public String addDirector(Director director) {
        directorList.put(director.getName(), director);
        return "director added to the directors list";
    }

    public String add_movie_director_pair(String movieName, String directorName) {
        List<String> listOfmovies = new ArrayList<>();
        if (directorMoviesList.containsKey(directorName)) {
            listOfmovies = directorMoviesList.get(directorName);
        }
        listOfmovies.add(movieName);
        directorMoviesList.put(directorName, listOfmovies);
        return "movie and director paired successfully";
    }

    public Movie getMovie(String name) {
        if (!movieList.containsKey(name)) { // if movie is not present in the list, what are you gonna do?
            return new Movie();
        }
        return movieList.get(name);
    }

    public Director getDirector(String name) {

        return directorList.get(name);
    }

    public List<String> get_movies_by_director_name(String name) {
        if (!directorMoviesList.containsKey(name)) return new ArrayList<>();
        return directorMoviesList.get(name);
    }

    public List<String> get_all_Movies() {
        List<String> listOfMovies = new ArrayList<>();
        for (String name : movieList.keySet()) {
            listOfMovies.add(name);
        }
        return listOfMovies;
    }

    public String delete_director_by_name(String name) {
        List<String> listOfMovies = new ArrayList<>();

        listOfMovies = directorMoviesList.get(name);
        for (String movie : listOfMovies) {
            if (movieList.containsKey(movie)) {
                movieList.remove(movie);
            }
        }
        if (directorList.containsKey(name))
            directorList.remove(name);
        return "deleted movies of the director";
    }

    public String delete_all_directors() {
        for (String directorName : directorList.keySet()) {
            List<String> listOfMovies = directorMoviesList.get(directorName);
            for (String m : listOfMovies) {
                if (movieList.containsKey(m)) {
                    movieList.remove(m);
                }
            }
            directorMoviesList.remove(directorName);
        }
        directorList.clear();
        return "deleted all directors movies";
    }
}
