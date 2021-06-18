package microservice.learn.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import microservice.learn.moviecatalogservice.models.CatalogItem;
import microservice.learn.moviecatalogservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public CatalogItem getCatalogItem(microservice.learn.moviecatalogservice.models.Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.movieId, Movie.class);
        return new CatalogItem(movie.getMovieName(), "Test", rating.getRating(), movie.getPort());
    }

    private CatalogItem getFallbackCatalogItem(microservice.learn.moviecatalogservice.models.Rating rating) {
        return new CatalogItem("Movie not found", "", rating.getRating(), "");
    }
}
