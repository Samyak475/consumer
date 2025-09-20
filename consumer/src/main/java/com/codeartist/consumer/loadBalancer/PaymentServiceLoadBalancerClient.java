package com.codeartist.consumer.loadBalancer;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceLoadBalancerClient {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer (LoadBalancerClientFactory loadBalancerClientFactory){
        return new RandomLoadBalancer(
                loadBalancerClientFactory.getLazyProvider("producer-service" , ServiceInstanceListSupplier.class),
                "producer-service"
        );
        // so here what happens is we are creating a bean of reactor load balancer, which will return service instance
//        and we are providing load balancer clientfactory , as this is used to store all the information for all the client
        // and there load balancer and their configuration
        // getLazyProvide will return ServiceInstanceListSupplier of producer service class only when requried.


    }
}
