package com.jgak.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class StockserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockserviceApplication.class, args);
	}

}
