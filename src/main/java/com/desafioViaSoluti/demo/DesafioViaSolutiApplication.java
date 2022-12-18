package com.desafioViaSoluti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.desafioViaSoluti.demo.percistence.entity"})
public class DesafioViaSolutiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioViaSolutiApplication.class, args);
	}

}
