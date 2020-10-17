package com.arakhman.ptbc.feignconfigexample;

import com.arakhman.ptbc.feignconfigexample.client.DummyRestApiExampleClient;
import com.arakhman.ptbc.feignconfigexample.client.JsonPlaceHolderClient;
import com.arakhman.ptbc.feignconfigexample.config.Config;
import com.arakhman.ptbc.feignconfigexample.utils.CustomFeignBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FeignConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignConfigApp.class);
    }

    @Autowired
    public Config config;

    @Autowired
    private CustomFeignBuilder customFeignBuilder;

    @Bean
    public DummyRestApiExampleClient getClient1() {
        return customFeignBuilder.builder("dummy")
                .target(DummyRestApiExampleClient.class, config.getDummyRestApiExampleEndPoint());
    }

    @Bean
    public JsonPlaceHolderClient getClient2() {
        return customFeignBuilder.builder("jsonplaceholder")
                .target(JsonPlaceHolderClient.class, config.getJsonPlaceHolderEndPoint());

    }
}
