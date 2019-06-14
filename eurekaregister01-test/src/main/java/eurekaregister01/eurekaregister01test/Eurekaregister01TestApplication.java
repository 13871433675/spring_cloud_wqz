package eurekaregister01.eurekaregister01test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eurekaregister01TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaregister01TestApplication.class, args);
	}

}
