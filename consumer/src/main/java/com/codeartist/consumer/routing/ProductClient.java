package com.codeartist.consumer.routing;

import com.codeartist.consumer.config.SecConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/producer/{id}")
    public  String getProduct(@PathVariable String id);
}
