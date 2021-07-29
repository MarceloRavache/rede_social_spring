package com.rede_social.rede_social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class RedeSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedeSocialApplication.class, args);
	}

}
