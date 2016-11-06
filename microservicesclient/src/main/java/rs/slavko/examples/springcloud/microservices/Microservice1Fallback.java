package rs.slavko.examples.springcloud.microservices;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class Microservice1Fallback implements Microservice1{
	public String greeting(String cheadCode){
		return "Fallback!";
	}
}
