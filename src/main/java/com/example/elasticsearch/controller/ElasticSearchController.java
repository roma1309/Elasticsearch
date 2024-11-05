package com.example.elasticsearch.controller;

import com.example.elasticsearch.dto.*;
import com.example.elasticsearch.entity.ProductEntity;
import com.example.elasticsearch.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/elastic")
public class ElasticSearchController {
    private final ElasticService elasticService;

    @Autowired
    public ElasticSearchController(ElasticService elasticService) {
        this.elasticService = elasticService;
    }


    @GetMapping()
    public ResponseEntity<String> createIndex() {
        elasticService.createIndex();
        return new ResponseEntity<>("successfully", HttpStatus.OK);
    }
}
