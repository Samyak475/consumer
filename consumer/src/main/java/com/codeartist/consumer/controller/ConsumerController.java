package com.codeartist.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> getProducerFrmConsumer(@PathVariable String id){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("producer-service");
        URI  uri = serviceInstances.get(0).getUri();
        String response = restTemplate.getForObject(uri+"/producer/"+id,String.class);

        return ResponseEntity.ok("called producer"+ response);
    }

}

