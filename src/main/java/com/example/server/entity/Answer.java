package com.example.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "answers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String text;

    private Integer answerNumber;

    private boolean isTrue;

    @ManyToOne
    private Test test;

    public Answer(String text, Integer answerNumber, boolean isTrue, Test test) {
        this.text = text;
        this.answerNumber = answerNumber;
        this.isTrue = isTrue;
        this.test = test;
    }
}
