package com.example.springbootmongodb;

import com.mongodb.client.MongoClient;
import io.mongock.driver.api.driver.ConnectionDriver;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableMongock
public class SpringbootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}

	// @Bean
// name of Method seems irrelevant
	//public ConnectionDriver mongockConnection(MongoClient mongoClient) {
	//	return SpringDataMongoV3Driver.withDefaultLock(mongoClient, "your databaseName");
	}

