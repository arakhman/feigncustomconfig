package com.arakhman.ptbc.feignconfigexample.type;

import lombok.Data;

import java.util.List;

@Data
public class DummyResult<T> {
    private String status;
    private List<T> data;

}
