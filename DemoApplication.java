package id.aldin.cimb.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
(exclude = {
	    org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration.class
	})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
