package com.tyning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

//	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
//	public String helloworld() {
//		System.out.println("************************");
//		return "helloworld";
//	}
}
