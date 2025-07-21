package br.com.fabioalvaro.poc_dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PocDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocDynamodbApplication.class, args);
	}

}
