package com.tyning.springboot.main;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haining
 */
@RestController
public class HelloWorldController {
    @GetMapping("/helloworld")
    public String helloworld() {
        System.out.println("************************");
        return "helloworld";
    }
}
