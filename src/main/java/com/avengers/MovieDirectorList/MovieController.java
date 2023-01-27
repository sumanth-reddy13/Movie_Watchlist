package com.avengers.MovieDirectorList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        String response = movieService.addMovie(movie);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        String response = movieService.addDirector(director);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity add_movie_director_pair(@RequestParam("movie") String movieName, @RequestParam("dName") String name) {
        String response = movieService.add_movie_director_pair(movieName, name);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovie(@PathVariable("name") String name) {
        Movie movie = movieService.getMovie(name);
        return new ResponseEntity(movie, HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirector(@PathVariable("name") String name) {
        Director director = movieService.getDirector(name);
        return new ResponseEntity(director, HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity get_movies_by_director_name(@PathVariable("director") String name) {
        List<String> movieList = movieService.get_movies_by_director_name(name);
        return new ResponseEntity(movieList, HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity get_all_Movies() {
        List<String> listOfMovies = movieService.get_all_Movies();
        return new ResponseEntity(listOfMovies, HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity delete_director_by_name(@RequestParam("name") String name) {
        String response = movieService.delete_director_by_name(name);
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity delete_all_directors() {
        String response = movieService.delete_all_directors();
        return new ResponseEntity(response, HttpStatus.FOUND);
    }
}
