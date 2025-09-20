package com.codeartist.consumer;

import com.codeartist.consumer.loadBalancer.GlobalLoadBalancerClient;
import com.codeartist.consumer.loadBalancer.PaymentServiceLoadBalancerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;

@SpringBootApplication
@LoadBalancerClients(defaultConfiguration = GlobalLoadBalancerClient.class, value={
		@LoadBalancerClient (name = "payment-service" , configuration= PaymentServiceLoadBalancerClient.class)
		})
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
