package io.github.MatheusFSantos.Kernel.KNUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class KnUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnUsersApplication.class, args);
	}

}
