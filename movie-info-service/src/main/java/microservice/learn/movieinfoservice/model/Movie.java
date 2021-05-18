package microservice.learn.movieinfoservice.model;

public class Movie {

    public String movieId;
    public String movieName;
    public String movieOverview;
    public String port;

    public Movie(String movieId, String movieName, String movieOverview, String port) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieOverview = movieOverview;
        this.port = port;
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

    public String getMovieOverview() {
        return movieOverview;
    }

    public Movie setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
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
