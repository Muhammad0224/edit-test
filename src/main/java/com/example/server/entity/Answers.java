//package com.example.server.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity(name = "answers")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Answers {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(columnDefinition = "text")
//    private String answer;
//
//    @ManyToOne
//    private Question question;
//
//    private Integer langValue;
//
//    private Integer value;
//
//    public Answers(String answer, Question question, Integer langValue, Integer value) {
//        this.answer = answer;
//        this.question = question;
//        this.langValue = langValue;
//        this.value = value;
//    }
//}
