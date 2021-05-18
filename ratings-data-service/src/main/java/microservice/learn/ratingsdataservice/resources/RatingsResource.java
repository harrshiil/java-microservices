package microservice.learn.ratingsdataservice.resources;

import microservice.learn.ratingsdataservice.models.Rating;
import microservice.learn.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getRatingByUser(@PathVariable("userId") String userId) {
        return new UserRating().setRatings(Arrays.asList(
                new Rating("550", 4),
                new Rating("100", 3)
        )).setUserId(userId);
    }
}
