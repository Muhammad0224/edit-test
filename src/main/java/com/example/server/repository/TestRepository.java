package com.example.server.repository;


import com.example.server.entity.Test;
import com.example.server.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findAllByVariantIdOrderByTestNumber(Integer variant_id);
}
