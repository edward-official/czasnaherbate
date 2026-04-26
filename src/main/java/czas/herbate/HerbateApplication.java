package czas.herbate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication: The entry point of a Spring Boot application.
 * This annotation includes @Configuration, @EnableAutoConfiguration, and @ComponentScan.
 * It tells Spring to start searching for beans (components) from this package and its sub-packages.
 */
@SpringBootApplication
public class HerbateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerbateApplication.class, args);
	}

}
