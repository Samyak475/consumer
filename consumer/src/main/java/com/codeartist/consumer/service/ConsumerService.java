package com.codeartist.consumer.service;

import com.codeartist.consumer.routing.ProductClient;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    ProductClient productClient;
    @RateLimiter(name ="productrate", fallbackMethod = "fallBackToBasicMethod" )
    public void getAllProducer(String id){
            String response = productClient.getProduct(id);
             System.out.println(response);
    }

    public  void fallBackToBasicMethod(String id , Throwable t){
        System.out.println("request timeout ");
    }
}
