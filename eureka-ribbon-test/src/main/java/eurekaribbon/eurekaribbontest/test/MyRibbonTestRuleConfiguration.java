package eurekaribbon.eurekaribbontest.test;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义lb策略
@Configuration
public class MyRibbonTestRuleConfiguration {
    @Bean
    public IRule myRibbonRule(){
        return new MyRule();
    }
}
