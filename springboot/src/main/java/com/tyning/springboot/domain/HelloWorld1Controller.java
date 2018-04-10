package com.tyning.springboot.domain;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haining
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
public class HelloWorld1Controller {
    @GetMapping("/helloworld1")
    public String helloworld() {
        System.out.println("************************");
        return "helloworld1";
    }
}
