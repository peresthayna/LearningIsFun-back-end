package br.edu.fema.LearningIsFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LearningIsFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningIsFunApplication.class, args);
	}

}
