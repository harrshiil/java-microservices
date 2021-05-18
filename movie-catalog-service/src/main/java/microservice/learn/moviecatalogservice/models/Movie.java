package microservice.learn.moviecatalogservice.models;

public class Movie {

    public String movieId;
    public String movieName;
    public String port;

    public Movie() {
    }

    public Movie(String movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public Movie setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getMovieName() {
        return movieName;
    }

    public Movie setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public String getPort() {
        return port;
    }

    public Movie setPort(String port) {
        this.port = port;
        return this;
    }
}
