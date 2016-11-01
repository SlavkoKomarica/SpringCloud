package rs.slavko.examples.springcloud.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class MicroservicesInfoPrinter {

	private static Logger logger = LoggerFactory
			.getLogger(MicroservicesInfoPrinter.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	public void print(String[] microservices) {
		for (String microservice : microservices) {
			printMicroserviceInfo(microservice);
		}
	}

	private void printMicroserviceInfo(String microserviceId) {
		List<ServiceInstance> serviceInstances = discoveryClient
				.getInstances(microserviceId);
		logger.info("Printing microservice {" + microserviceId + "} info.");
		for (int i = 0; i < serviceInstances.size(); i++) {
			logger.info("Instance " + (i + 1) + ". info");
			printMicroserviceInstanceInfo(serviceInstances.get(i));
		}
	}

	private void printMicroserviceInstanceInfo(ServiceInstance s) {
		logger.info("Host: " + s.getHost());
		logger.info("Port: " + s.getPort());
		logger.info("Uri:" + s.getUri());
	}
}