package eurekaribbon.eurekaribbontest.test;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

//自定义拦截器测试
public class MyLoadBalancerinterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, final ClientHttpRequestExecution execution) throws IOException {
        final URI originalUri = request.getURI();
        String serviceName = originalUri.getHost();
        System.out.println("wangqizhi's iterceptor"+originalUri+"  "+serviceName);
        return execution.execute(request, body);
    }
}
