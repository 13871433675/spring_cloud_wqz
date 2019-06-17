package eurekaribbon.eurekaribbontest.test;

import java.util.List;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class MyRule implements IRule {

    private ILoadBalancer lb;

    @Override
    public Server choose(Object key) {
        List<Server> serverList = lb.getAllServers();
        for (Server server : serverList) {
            System.out.println(server.getHostPort());
        }
        return serverList.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb=lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
