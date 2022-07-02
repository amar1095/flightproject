package com.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAwsApplication {
	
	public String getHellow() {
		return "hi this his aws deploy application";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsApplication.class, args);
	}

}
