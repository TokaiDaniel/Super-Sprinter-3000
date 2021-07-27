package com.codecool.superSprinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class SuperSprinterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperSprinterApplication.class, args);
	}
}
