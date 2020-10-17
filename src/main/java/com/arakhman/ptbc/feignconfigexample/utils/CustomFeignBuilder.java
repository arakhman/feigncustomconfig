package com.arakhman.ptbc.feignconfigexample.utils;

import com.arakhman.ptbc.feignconfigexample.config.Config;
import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomFeignBuilder {
    @Autowired
    private Config config;

    public Feign.Builder builder(String clientName) {
        HttpClientBuilder clientBuilder = HttpClients
                .custom();

        Map<String, Integer> clientProp = config.getClient().get(clientName);
        if (clientProp == null) {
            clientProp = config.getClient().get("default");
        }

        if (clientProp != null) {
            Integer maxConn = clientProp.get("max-connections");
            if (maxConn != null && maxConn > 0) {
                clientBuilder.setMaxConnTotal(maxConn);
            }

            Integer maxPerRoute = clientProp.get("max-connections-per-route");
            if (maxPerRoute != null && maxPerRoute > 0) {
                clientBuilder.setMaxConnPerRoute(maxPerRoute);
            }
        }

        return Feign.builder().client(new ApacheHttpClient(clientBuilder.build()))
                .decoder(new JacksonDecoder());
    }
}
