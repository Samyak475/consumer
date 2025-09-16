package com.codeartist.consumer.controller;

import com.codeartist.consumer.routing.ProductClient;
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
    ProductClient productClient;
    @GetMapping("/{id}")
    public ResponseEntity<String> getProducerFrmConsumer(@PathVariable String id){

    String response = productClient.getProduct(id);
        return ResponseEntity.ok("called producer"+response);
    }

}

