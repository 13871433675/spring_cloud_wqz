package eurekaribbon.eurekaribbontest.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyLoadBalancerAutoConfiguration {
    @MyLoadBalanced
    @Autowired(required = false)
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @Bean
    public MyLoadBalancerinterceptor myLoadBalancerInterceptornterceptor ( ) {
        return new MyLoadBalancerinterceptor();
    }

    @Bean
    public SmartInitializingSingleton myLoadBalancedRestTemplateinitializer(final ObjectProvider<List<RestTemplateCustomizer>> restTemplateCustomizers){
//        return  () -> restTemplateCustomizers.ifAvailable(customizers -> {
//            for (RestTemplate restTemplate : MyLoadBalancerAutoConfiguration.this.restTemplates)
//                for (RestTemplateCustomizer customizer : customizers) {
//                    customizer.customize(restTemplate);
//                }
//        });
            return  new SmartInitializingSingleton() {
                @Override
                public void afterSingletonsInstantiated() {
                    for (RestTemplate restTemplate : MyLoadBalancerAutoConfiguration.this.restTemplates) {
                        List<ClientHttpRequestInterceptor> list = new
                                ArrayList<>(restTemplate.getInterceptors());
                        list.add(myLoadBalancerInterceptornterceptor());
                        restTemplate.setInterceptors(list);
                    }
                }
            };
    }
}
