package rs.slavko.examples.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Microservice1Application {
	
	private Logger logger = LoggerFactory
			.getLogger(Microservice1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/greeting")
    public String greeting() {
		logger.info("greeting endpoint invoked!");
        return "Hello from Microservice1!";
    }
}
