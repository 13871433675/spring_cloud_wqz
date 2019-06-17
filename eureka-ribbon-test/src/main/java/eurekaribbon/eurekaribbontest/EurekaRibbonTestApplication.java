package eurekaribbon.eurekaribbontest;

import eurekaribbon.eurekaribbontest.test.MyRibbonTestRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@RibbonClient(name="service-ribbon",configuration = MyRibbonTestRuleConfiguration.class)
public class EurekaRibbonTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRibbonTestApplication.class, args);
	}

	@Bean
   @LoadBalanced
//    @MyLoadBalanced
    RestTemplate restTemplate(){
	    return new RestTemplate();
    }

}
