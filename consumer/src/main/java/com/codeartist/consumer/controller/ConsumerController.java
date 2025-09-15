package com.codeartist.consumer.controller;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.SQLOutput;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    RestClient restClient;
    @GetMapping("/{id}")
    public ResponseEntity<String> getProducerFrmConsumer(@PathVariable String id){
        String response1 = restClient.get()
                .uri("http://localhost:8082/producer/"+id)

                .retrieve().onStatus(response -> {
                    if(response.getStatusCode().is4xxClientError()){
                        throw new IOException("Throw exception");
                    }
                    return false ;
                }).body(String.class);

        return ResponseEntity.ok("called producer"+response1);
    }

}

