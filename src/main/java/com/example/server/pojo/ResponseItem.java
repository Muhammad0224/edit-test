package com.example.server.pojo;

import java.util.List;
import lombok.Data;

@Data
public class ResponseItem{
	private List<TestsItem> tests;
	private int id;
}