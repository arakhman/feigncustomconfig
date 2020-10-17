package com.arakhman.ptbc.feignconfigexample.client;

import com.arakhman.ptbc.feignconfigexample.type.Post;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

public interface JsonPlaceHolderClient {
    @RequestLine("GET /posts")
    @Headers("Content-Type: application/json")
    List<Post> getPosts();
}
