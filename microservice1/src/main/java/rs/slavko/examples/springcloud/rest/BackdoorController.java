package rs.slavko.examples.springcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.slavko.examples.springcloud.actuator.MyHealthIndicator;

/**
 * Created by slavko.komarica on 11/2/2016.
 */
@RestController
public class BackdoorController {

    @Autowired
    private MyHealthIndicator myHealthIndicator;

    @RequestMapping(method = RequestMethod.GET, value = "/backdoor")
    public String backdoor(@RequestParam(value = "magicString", required = true) String magicString) {
        if (magicString.equalsIgnoreCase("you-are-dead")) {
            myHealthIndicator.setDead(true);
        } else if (magicString.equalsIgnoreCase("resurrection")) {
            myHealthIndicator.setDead(false);
        }
        return "You'r magic string has been accepted";
    }
}
