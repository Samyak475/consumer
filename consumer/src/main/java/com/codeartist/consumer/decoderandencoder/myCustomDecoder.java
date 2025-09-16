package com.codeartist.consumer.decoderandencoder;

import com.codeartist.consumer.routing.ProductClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;


public class myCustomDecoder implements Decoder {

    @Override
    public Object decode (Response response , Type type){
        try {
            InputStream is = response.body().asInputStream();
            return new ObjectMapper().readValue(is, new TypeReference<Object>() {
                @Override
                public  Type getType(){
                    return type;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
