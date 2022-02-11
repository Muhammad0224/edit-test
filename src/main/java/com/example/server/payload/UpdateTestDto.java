package com.example.server.payload;

import com.example.server.entity.Answer;
import com.example.server.entity.Variant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateTestDto {
    private Integer id;

    private String text;

    private List<Answer> answers;
}
