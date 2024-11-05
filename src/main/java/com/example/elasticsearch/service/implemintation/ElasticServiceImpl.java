package com.example.elasticsearch.service.implemintation;

import com.example.elasticsearch.entity.ProductEntity;
import com.example.elasticsearch.repository.ProductRepository;
import com.example.elasticsearch.service.ElasticService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ElasticServiceImpl implements ElasticService {
    private final RestTemplate restTemplate;
    private final ProductRepository productRepo;

    @Autowired
    public ElasticServiceImpl(RestTemplate restTemplate, ProductRepository productRepo) {
        this.restTemplate = restTemplate;
        this.productRepo = productRepo;
    }

    @Override
    public ResponseEntity<Object> createIndex() {
        String json = "{\n" +
                "    \"mappings\": {\n" +
                "        \"properties\": {\n" +
                "            \"name\": {\n" +
                "                \"type\": \"text\"\n" +
                "            },\n" +
                "            \"dateCreate\": {\n" +
                "                \"type\": \"date\"\n" +
                "            },\n" +
                "            \"scuDto\": {\n" +
                "               \"type\": \"nested\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        gson.fromJson(json, Object.class);
        HttpEntity<Object> requestEntity = new HttpEntity<>(gson.fromJson(json, Object.class));
        ParameterizedTypeReference<Object> ind = new ParameterizedTypeReference<Object>() {

        };
        try {
            restTemplate.exchange("http://localhost:9200/first17_index", HttpMethod.PUT, requestEntity, ind);
        } catch (RuntimeException e) {
            System.out.println("this index created");
        }
        createDocs();
        return null;
    }

    @Override
    public void deleteAllDocs() {

        String json = "{\n" +
                " \"query\": {\n" +
                " \"match_all\": {}\n" +
                " }\n" +
                "}";
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        gson.fromJson(json, Object.class);
        HttpEntity<Object> requestEntity = new HttpEntity<>(gson.fromJson(json, Object.class));
        ParameterizedTypeReference<Object> ind = new ParameterizedTypeReference<Object>() {
        };
        restTemplate.exchange("http://localhost:9200/first17_index/_delete_by_query?conflicts=proceed", HttpMethod.POST, requestEntity, ind);
    }

    @Override
    public List<ProductEntity> createDocs() {

        List<ProductEntity> productEntities = productRepo.findAll();
        ParameterizedTypeReference<Object> ind = new ParameterizedTypeReference<Object>() {

        };
        String str1 = "";
        for (ProductEntity productEntity : productEntities) {
            str1 = str1 + productEntity.toStringJson() + '\n';
        }
        deleteAllDocs();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(str1, headers);
        restTemplate.postForEntity("http://localhost:9200/first17_index/_bulk", entity, Object.class);
        return productEntities;
    }
}
