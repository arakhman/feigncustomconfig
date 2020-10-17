package com.arakhman.ptbc.feignconfigexample.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "custom-feign")
@Data
public class Config {

    private Map<String, Map<String, Integer>> client = new HashMap<>();
    private String dummyRestApiExampleEndPoint;
    private String jsonPlaceHolderEndPoint;

}
