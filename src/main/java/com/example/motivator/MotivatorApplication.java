package com.example.motivator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MotivatorApplication {

	public static void main(String[] args) {

		SpringApplication.run(MotivatorApplication.class, args);

	}

}
