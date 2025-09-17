package com.codeartist.consumer.config;

import com.codeartist.consumer.decoderandencoder.myCustomDecoder;
import com.codeartist.consumer.decoderandencoder.myCustomEncoder;
import com.codeartist.consumer.decoderandencoder.myCustomRetryer;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecConfig {

    @Bean
    public Decoder myCustomDecoder(){
        return new myCustomDecoder();
    }

    @Bean
    public Encoder myCustomEncoder(){
        return new myCustomEncoder();
    }

    @Bean
    public Retryer myCustomRetryer(){
        return new myCustomRetryer();
    }
}
