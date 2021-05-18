package microservice.learn.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import microservice.learn.moviecatalogservice.models.Rating;
import microservice.learn.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class UserRatingService {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeInMilliseconds", value = "2000"), // wait for this long to and if still no response then timeout
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), // the number of requests its to see
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), // percentage of request are failing
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") // not to request for this time after knowing circuit is broken
            }
    )
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
    }

    private UserRating getFallbackUserRating(String userId) {
        return new UserRating()
                .setUserId(userId)
                .setRatings(Collections.singletonList(new Rating("0", 0)));
    }
}
