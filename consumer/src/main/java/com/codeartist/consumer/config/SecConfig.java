package com.codeartist.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecConfig {

    @Bean
    @LoadBalanced  // this annotaion will call service discovery get all instances and then call the load balancer algo using service id
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
