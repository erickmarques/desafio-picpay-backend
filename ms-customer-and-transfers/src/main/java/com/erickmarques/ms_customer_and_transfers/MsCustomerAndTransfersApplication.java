package com.erickmarques.ms_customer_and_transfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class MsCustomerAndTransfersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerAndTransfersApplication.class, args);
	}

}
