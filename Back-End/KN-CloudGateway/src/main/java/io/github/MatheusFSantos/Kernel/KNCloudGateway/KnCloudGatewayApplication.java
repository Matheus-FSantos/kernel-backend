package io.github.MatheusFSantos.Kernel.KNCloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class KnCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnCloudGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator router(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder
					.routes()
					.route(r -> r.path("/api/users/**")
						.and()
						.path("/api/backup/users/**")
						.uri("lb://kn-users")
					)
					.build();
	}

}
