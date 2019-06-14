package eurekafeigntest.eurekafeigntest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EurekaFeignTest01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignTest01Application.class, args);
	}

}
