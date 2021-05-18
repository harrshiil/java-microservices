package microservice.learn.ratingsdataservice.models;

import java.util.ArrayList;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> ratings = new ArrayList<>();

    public String getUserId() {
        return userId;
    }

    public UserRating setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public UserRating setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }
}
