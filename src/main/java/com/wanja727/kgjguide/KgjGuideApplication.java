package com.wanja727.kgjguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KgjGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(KgjGuideApplication.class, args);
	}
}
