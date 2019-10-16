package com.thimeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
public class ThymeleafLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafLoginApplication.class, args);
	}

}
