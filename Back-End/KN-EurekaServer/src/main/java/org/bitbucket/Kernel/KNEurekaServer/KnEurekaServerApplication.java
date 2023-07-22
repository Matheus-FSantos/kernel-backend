package org.bitbucket.Kernel.KNEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class KnEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnEurekaServerApplication.class, args);
	}

}
