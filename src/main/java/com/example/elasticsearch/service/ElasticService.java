package com.example.elasticsearch.service;


import com.example.elasticsearch.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ElasticService {
    public ResponseEntity<Object> createIndex();
    public void deleteAllDocs();

    public List<ProductEntity> createDocs();

}
