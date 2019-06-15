package servicezuul.servicezuultest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulTest01Application {
//Zuul的主要功能是路由转发和过滤器
	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulTest01Application.class, args);
	}

}
