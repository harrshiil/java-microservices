package microservice.learn.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient // Optional
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

	/*
	it does service discovery,
	client side load balancing because of client side service discovery,
	client will decide whom to call. this all happens in background

	Client side load balancing is not effective cause theoretically
	what if all clients choose single instance to call

	@LoadBalanced is automatically will do load balancing from client side
	if you want to use more advanced load balancing, or hit the instance on some conditions
	then you can use DiscoveryClient interface by autowired.
	*/

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		clientHttpRequestFactory.setConnectTimeout(3000);
//		return new RestTemplate(clientHttpRequestFactory);
        return new RestTemplate();
    }

//    @Bean
//    public WebClient getWebClientBuilder() {
//        return WebClient.builder().build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

}
