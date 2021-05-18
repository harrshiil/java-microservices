package microservice.learn.moviecatalogservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.learn.moviecatalogservice.models.CatalogItem;
import microservice.learn.moviecatalogservice.models.Movie;
import microservice.learn.moviecatalogservice.models.Rating;
import microservice.learn.moviecatalogservice.models.UserRating;
import microservice.learn.moviecatalogservice.service.MovieInfoService;
import microservice.learn.moviecatalogservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    public RestTemplate restTemplate;

    /*Hystrix will always need to create proxy class to provide instance.
    And it can create proxy classes only for annotade classes.*/
    @Autowired
    public MovieInfoService movieInfoService;

    @Autowired
    public UserRatingService userRatingService;

//    @Autowired
//    public WebClient webClient;

    /*
    if movieInfoService is not reachable then it will call fallback method
    */
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // rest template will get actual location of service from eureka through @LoadBalanced annotation
        UserRating userrating = userRatingService.getUserRating(userId);

        return userrating.getRatings().stream()
                .map(rating -> movieInfoService.getCatalogItem(rating))
                .collect(Collectors.toList());
    }




}

/* Async Way
           Movie movie = webClient
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.movieId)
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block(); // the block line will make it sync.*/