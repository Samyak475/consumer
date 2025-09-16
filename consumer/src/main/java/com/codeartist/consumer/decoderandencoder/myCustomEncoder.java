package com.codeartist.consumer.decoderandencoder;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestTemplate;
import feign.codec.Encoder;

import java.lang.reflect.Type;

public class myCustomEncoder  implements Encoder {

    @Override
    public  void encode(Object object , Type body , RequestTemplate template){
        try {
            String resBody = new ObjectMapper().writeValueAsString(object);
            template.body(resBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
