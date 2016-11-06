package rs.slavko.examples.springcloud.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.slavko.examples.springcloud.microservices.Microservice1;

@RestController
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private Microservice1 microservice1;

	@RequestMapping(value="makeRequest")
	public String makeRequest(@RequestParam("param") String param){
		makeMicroservice1Call(param);
		return "Success";
	}
	
	private void makeMicroservice1Call(String param) {
		logger.info("Invoking microservice1. Result: "+microservice1.greeting(param));
	}
}
