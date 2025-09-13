package com.codeartist.consumer.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import ch.qos.logback.core.util.SystemInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController()
@RequestMapping("/consumer")
public class ConsumerController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductFromConsumer(@PathVariable String id){
        // this is used to set up UCP Connection
        HttpURLConnection httpURLConnection = null;
        try {
            // manually set the url
            String urlVal = "http://localhost:8082/producer/";
            URL url = new URL(urlVal+id);
            // open connection doesnot connec two services, it is just used to make the HTTP request body
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept","application/json");
            // getInputStream and getResponse are used to send the request to given url and get the response;
            // at this point connection is establised with other service, also if in  UCP Cache , we store mapping
            // of http url port with its http client. so if we have existing httpclient at same url:port with flag close
            // we will set flag as active and use that http client.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            StringBuffer response = new StringBuffer();
            String responseReader ;
            while((responseReader = bufferedReader.readLine()) !=null){
                response.append(responseReader);
            }
            bufferedReader.close();
            System.out.println("successfully read the response"+response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally{
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return ResponseEntity.ok("order called successfully");
    }
}
