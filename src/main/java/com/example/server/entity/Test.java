package com.example.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "tests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String text;

    private Integer type;

    private Integer typeImage;

    private Integer testNumber;

    @ManyToOne
    private Variant variant;

    public Test(String text, Integer type, Integer typeImage, Integer testNumber, Variant variant) {
        this.text = text;
        this.type = type;
        this.typeImage = typeImage;
        this.testNumber = testNumber;
        this.variant = variant;
    }
}
