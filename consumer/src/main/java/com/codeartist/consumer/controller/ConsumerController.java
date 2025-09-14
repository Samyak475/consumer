package com.codeartist.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/{id}")
    public ResponseEntity<String> getProducerFrmConsumer(@PathVariable String id){
        String producer = "http://localhost:8081/producer/"+id;
        String response = restTemplate.getForObject(producer, String.class);
        System.out.println("Inside consumser got producer code "+ response);
        return ResponseEntity.ok("called producer");
    }

}

