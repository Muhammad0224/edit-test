//package com.example.server.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity(name = "question")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Question {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(columnDefinition = "text")
//    private String question;
//
//    @Column(columnDefinition = "text")
//    private String questionUzk;
//
//    @Column(columnDefinition = "text")
//    private String questionRu;
//
//    @Column(columnDefinition = "text")
//    private String comment;
//
//    @Column(columnDefinition = "text")
//    private String commentUzk;
//
//    @Column(columnDefinition = "text")
//    private String commentRu;
//
//    private Integer type;
//
//    private Integer typeImage;
//
//    private Integer biletNumber;
//
//    private Integer orders;
//
//    public Question(String question, String questionUzk, String questionRu, Integer type, Integer typeImage, Integer biletNumber, Integer order) {
//        this.question = question;
//        this.questionUzk = questionUzk;
//        this.questionRu = questionRu;
//        this.type = type;
//        this.typeImage = typeImage;
//        this.biletNumber = biletNumber;
//        this.orders = order;
//    }
//}
