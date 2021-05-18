package microservice.learn.movieinfoservice.model;

public class MovieSummary {

    private String id;
    private String title;
    private String overview;

    public String getId() {
        return id;
    }

    public MovieSummary setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieSummary setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public MovieSummary setOverview(String overview) {
        this.overview = overview;
        return this;
    }
}
