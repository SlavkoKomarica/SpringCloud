package rs.slavko.examples.springcloud.microservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("microservice1")
public interface Microservice1 {
	@RequestMapping(method = RequestMethod.GET, value="/greeting")
    public String greeting();
}
