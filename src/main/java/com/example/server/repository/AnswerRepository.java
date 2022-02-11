package com.example.server.repository;


import com.example.server.entity.Answer;
import com.example.server.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllByTestIdOrderByAnswerNumber(Integer test_id);
}
