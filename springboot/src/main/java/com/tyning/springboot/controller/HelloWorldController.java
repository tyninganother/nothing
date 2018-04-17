package com.tyning.springboot.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haining
 */
@RestController
public class HelloWorldController {
//    @GetMapping("/helloworld")
    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    public String helloworld() {
        System.out.println("************************");
        return "helloworld";
    }
}
