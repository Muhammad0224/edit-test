package com.example.server.payload;

import com.example.server.entity.Answer;
import com.example.server.entity.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private Integer id;
    private String text;
    private Integer testNumber;
    private Variant variant;
    private List<Answer> answers;
}
