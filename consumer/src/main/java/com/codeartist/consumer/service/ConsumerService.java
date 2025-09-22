package com.codeartist.consumer.service;

import com.codeartist.consumer.routing.ProductClient;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    ProductClient productClient;
    @Retry(name ="productrate", fallbackMethod = "fallBackToBasicMethod" )
    public void getAllProducer(String id){
        String response="";
        try{
           response  = productClient.getProduct(id);

        } catch (Exception e) {
            System.out.println("product service is not responding");
            throw e;
        }
        System.out.println("Product service called "+ response);

    }

    public  void fallBackToBasicMethod(String id , Throwable t){
        System.out.println("request timeout ");
    }
}
