package buddle.buddlebuddy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String testController() {
        return "hello";
    }

    @RequestMapping("/test")
    public String jenkinsTestController() {
        return "hello jenkins";
    }

    @RequestMapping("/user/test")
    public String loginTestController() {
        return "hello user";
    }

    @RequestMapping("/test/jenkins")
    public String jenkinsTestController2() {
        return "jenkins test!!";
    }
}
