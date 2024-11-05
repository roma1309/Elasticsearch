package com.example.elasticsearch.service;

import com.example.elasticsearch.dto.ProductDto;
import com.example.elasticsearch.entity.ProductEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getProducts(Boolean isAvailability, String name) throws JsonProcessingException;

    
}
