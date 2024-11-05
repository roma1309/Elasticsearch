package com.example.elasticsearch.controller;

import com.example.elasticsearch.dto.ProductDto;
import com.example.elasticsearch.entity.ProductEntity;
import com.example.elasticsearch.service.ElasticService;
import com.example.elasticsearch.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ElasticService elasticService;

    @Autowired
    public ProductController(ProductService productService, ElasticService elasticService) {
        this.productService = productService;
        this.elasticService = elasticService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(value = "is_availability", required = false) final Boolean isAvailability,
                                                        @RequestParam(value = "name", required = false) final String name) throws JsonProcessingException {

        return new ResponseEntity<>(productService.getProducts(isAvailability, name), HttpStatus.OK);
    }
}
