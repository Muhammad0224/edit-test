package com.example.server.repository;


import com.example.server.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
    List<Variant> findAllByLang(String lang);
}
