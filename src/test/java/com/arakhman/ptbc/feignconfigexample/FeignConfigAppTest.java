package com.arakhman.ptbc.feignconfigexample;

import com.arakhman.ptbc.feignconfigexample.client.DummyRestApiExampleClient;
import com.arakhman.ptbc.feignconfigexample.client.JsonPlaceHolderClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class FeignConfigAppTest {

    @Autowired
    DummyRestApiExampleClient client1;
    @Autowired
    JsonPlaceHolderClient client2;

    @Test
    void test1() {
        assertThat(client1.getAllEmployee().getData().isEmpty(), is(false));
    }

    @Test
    void test2() {
        assertThat(client2.getPosts().isEmpty(), is(false));
    }
}