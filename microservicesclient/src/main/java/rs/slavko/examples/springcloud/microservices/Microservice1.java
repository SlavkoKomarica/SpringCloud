package rs.slavko.examples.springcloud.microservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="microservice1", fallback=Microservice1Fallback.class)       
public interface Microservice1 {
	@RequestMapping(method = RequestMethod.GET, value="/greeting")
    public String greeting(@RequestParam("cheatCode") String cheadCode);
}
