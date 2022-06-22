package com.letowski.plantsitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

@SpringBootApplication

@EnableFeignClients(basePackages = {"com.letowski.plantsitter"})
public class PlantSitterApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
		SpringApplication.run(PlantSitterApplication.class, args);

	}

}
