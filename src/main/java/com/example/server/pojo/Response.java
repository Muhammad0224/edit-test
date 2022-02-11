package com.example.server.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private List<ResponseItem> items;
}
