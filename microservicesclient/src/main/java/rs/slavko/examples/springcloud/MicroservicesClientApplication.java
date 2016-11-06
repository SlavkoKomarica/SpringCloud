package rs.slavko.examples.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import rs.slavko.examples.springcloud.util.MicroservicesInfoPrinter;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MicroservicesClientApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory
			.getLogger(MicroservicesClientApplication.class);

	private static final String MICROSERVICE_1 = "microservice1";
	private static final String MICROSERVICE_2 = "microservice2";
	private static final String[] MICROSERVICES = new String[] {
			MICROSERVICE_1, MICROSERVICE_2 };

	@Autowired
	private MicroservicesInfoPrinter microservicesInfoPrinter;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		microservicesInfoPrinter.print(MICROSERVICES);
	}

}
