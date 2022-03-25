package com.obr.facturation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.obr.facturation")

@SpringBootApplication
public class FacturationApplication {


	public static void main(String[] args) {
		
		SpringApplication.run(FacturationApplication.class, args);
	
	}
	

		
	

}
