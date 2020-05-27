package com.example.youyoueureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YouyoueurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouyoueurekaApplication.class, args);
	}

}
