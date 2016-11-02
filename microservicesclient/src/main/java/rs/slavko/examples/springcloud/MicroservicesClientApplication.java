package rs.slavko.examples.springcloud;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import org.springframework.context.annotation.Bean;
import rs.slavko.examples.springcloud.microservices.Microservice1;
import rs.slavko.examples.springcloud.util.MicroservicesInfoPrinter;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroservicesClientApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory
			.getLogger(MicroservicesClientApplication.class);

	private static final String MICROSERVICE_1 = "microservice1";
	private static final String MICROSERVICE_2 = "microservice2";
	private static final String[] MICROSERVICES = new String[] {
			MICROSERVICE_1, MICROSERVICE_2 };
	
	@Autowired
	private MicroservicesInfoPrinter microservicesInfoPrinter;
	@Autowired
	private Microservice1 microservice1;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int numberOfRequests = 90;
		for(int i=0; i<numberOfRequests; i++){
			try {
				logger.info("Invoking microservice1. Result: "+microservice1.greeting());
			}catch (Exception e){
				logger.info("Error executing request",e);
			}
		}
		microservicesInfoPrinter.print(MICROSERVICES);
	}

	
}
