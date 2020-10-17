package com.arakhman.ptbc.feignconfigexample.client;

import com.arakhman.ptbc.feignconfigexample.type.DummyResult;
import com.arakhman.ptbc.feignconfigexample.type.Employee;
import feign.Headers;
import feign.RequestLine;

public interface DummyRestApiExampleClient {
    @RequestLine("GET ")
    @Headers({"Content-Type: application/json"})
    DummyResult<Employee> getAllEmployee();
}
