package com.example.server.pojo;

import java.util.List;
import lombok.Data;

@Data
public class TestsItem{
	private List<AnswersItem> answers;
	private int id;
	private String text;
	private int type;
	private int typeimage;
}