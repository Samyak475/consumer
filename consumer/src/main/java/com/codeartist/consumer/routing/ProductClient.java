package com.codeartist.consumer.routing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",url = "${feign.client.product-service.uri}")
public interface ProductClient {

    @GetMapping("/producer/{id}")
    public  String getProduct(@PathVariable String id);
}
