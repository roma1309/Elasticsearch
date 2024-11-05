package com.example.elasticsearch.service.implemintation;

import com.example.elasticsearch.converter.ProductConverter;
import com.example.elasticsearch.dto.ProductDto;
import com.example.elasticsearch.entity.ProductEntity;
import com.example.elasticsearch.repository.ProductRepository;
import com.example.elasticsearch.service.ProductService;
import com.example.elasticsearch.utils.Url;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo, RestTemplate restTemplate, ObjectMapper mapper) {
        this.productRepo = productRepo;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> getProducts(Boolean isAvailability, String name) throws JsonProcessingException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        if (isAvailability == null && name == null) {

            ResponseEntity<Object> response = restTemplate.getForEntity(Url.SEARCH_PRODUCTS, Object.class);
            JsonObject jsonObject = new Gson().fromJson(mapper.writeValueAsString(response), JsonObject.class);
            JsonObject hits = jsonObject.getAsJsonObject("body").get("hits").getAsJsonObject();
            JsonArray products = hits.getAsJsonArray("hits");
            List<ProductDto> productDtoList = new ArrayList<>();
            for (JsonElement jsonArray : products) {
                productDtoList.add(ProductConverter.jsonToDto(jsonArray.getAsJsonObject().get("_source")));
            }
            return productDtoList;
        } else if (isAvailability != null && name != null) {
            String json = " { \n" +
                    "   \"query\": {\n" +
                    "        \"bool\": {\n" +
                    "             \"must\": [{\n" +
                    "                \"match_phrase\": {\n" +
                    "                   \"scuDto.isAvailability\":" + isAvailability + "\n" +
                    "                  }\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"match_phrase\": {\n" +
                    "                   \"name\":" + name + "\n" +
                    "                  }\n" +
                    "                }\n" +
                    "             ] \n" +
                    "         }\n" +
                    "   }\n" +
                    "}";
            ParameterizedTypeReference<Object> ind = new ParameterizedTypeReference<Object>() {
            };
            HttpEntity<Object> requestEntity = new HttpEntity<>(gson.fromJson(json, Object.class));
            ResponseEntity<Object> productDto = restTemplate.exchange(Url.SEARCH_PRODUCTS, HttpMethod.POST, requestEntity, ind);
            JsonObject jsonObject = new Gson().fromJson(mapper.writeValueAsString(productDto), JsonObject.class);
            JsonObject hits = jsonObject.getAsJsonObject("body").get("hits").getAsJsonObject();
            JsonArray products = hits.getAsJsonArray("hits");
            List<ProductDto> productDtoList = new ArrayList<>();
            for (JsonElement jsonArray : products) {
                productDtoList.add(ProductConverter.jsonToDto(jsonArray.getAsJsonObject().get("_source")));
            }
            return productDtoList;
        } else if (name == null) {
            String json = "{\n" +
                    "  \"query\": {\n" +
                    "    \"match_phrase\" : {\n" +
                    "      \"scuDto.isAvailability\":" + isAvailability + "\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            ParameterizedTypeReference<Object> ind = new ParameterizedTypeReference<Object>() {
            };
            HttpEntity<Object> requestEntity = new HttpEntity<>(gson.fromJson(json, Object.class));
            ResponseEntity<Object> productDto = restTemplate.exchange(Url.SEARCH_PRODUCTS, HttpMethod.POST, requestEntity, ind);
            JsonObject jsonObject = new Gson().fromJson(mapper.writeValueAsString(productDto), JsonObject.class);
            JsonObject hits = jsonObject.getAsJsonObject("body").get("hits").getAsJsonObject();
            JsonArray products = hits.getAsJsonArray("hits");
            List<ProductDto> productDtoList = new ArrayList<>();
            for (JsonElement jsonArray : products) {
                productDtoList.add(ProductConverter.jsonToDto(jsonArray.getAsJsonObject().get("_source")));
            }
            return productDtoList;
        } else {
            String json = "{\n" +
                    "  \"query\": {\n" +
                    "    \"wildcard\":{\n" +
                    "    \"name\" : {\n" +
                    "      \"value\":" +  '"'+ "*" + name + "*" + '"'+ "\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n" +
                    "}";
            ParameterizedTypeReference<Object> ind = new ParameterizedTypeReference<Object>() {
            };
            HttpEntity<Object> requestEntity = new HttpEntity<>(gson.fromJson(json, Object.class));
            ResponseEntity<Object> productDto = restTemplate.exchange(Url.SEARCH_PRODUCTS, HttpMethod.POST, requestEntity, ind);
            JsonObject jsonObject = new Gson().fromJson(mapper.writeValueAsString(productDto), JsonObject.class);
            JsonObject hits = jsonObject.getAsJsonObject("body").get("hits").getAsJsonObject();
            JsonArray products = hits.getAsJsonArray("hits");
            List<ProductDto> productDtoList = new ArrayList<>();
            for (JsonElement jsonArray : products) {
                productDtoList.add(ProductConverter.jsonToDto(jsonArray.getAsJsonObject().get("_source")));
            }
            return productDtoList;
        }
    }
}
