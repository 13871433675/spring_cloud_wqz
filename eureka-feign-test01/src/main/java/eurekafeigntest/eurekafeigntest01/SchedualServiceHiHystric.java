package eurekafeigntest.eurekafeigntest01;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "Hystrix in feign :sorry"+ name;
    }
}
