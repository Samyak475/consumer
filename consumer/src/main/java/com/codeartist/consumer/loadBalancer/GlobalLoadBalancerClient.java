package com.codeartist.consumer.loadBalancer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ConditionalOnMissingBean()
public class GlobalLoadBalancerClient {

    @Bean
    public ReactorLoadBalancer<ServiceInstance>randomLoadBalancer(LoadBalancerClientFactory factory , Environment environment){
        String serviceId = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RoundRobinLoadBalancer(factory.getLazyProvider(serviceId, ServiceInstanceListSupplier.class),serviceId);
    }
}
