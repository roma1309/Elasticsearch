package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.SkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuRepository extends JpaRepository<SkuEntity, Long> {
}
