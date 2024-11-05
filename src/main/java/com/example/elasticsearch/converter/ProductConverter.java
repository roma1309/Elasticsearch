package com.example.elasticsearch.converter;

import com.example.elasticsearch.dto.ProductDto;
import com.example.elasticsearch.dto.ScuDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductConverter {

    public static ProductDto jsonToDto(JsonElement jsonObject) {
        ProductDto productDto = new ProductDto();
        Gson gson = new Gson();
        productDto = gson.fromJson(jsonObject.getAsJsonObject(), ProductDto.class);
        JsonArray scuList = jsonObject.getAsJsonObject().getAsJsonArray("scuDto");
        List<ScuDto> scuDtoList = new ArrayList<>();
        for (JsonElement jsonScu : scuList) {
            scuDtoList.add(ScuConverter.jsonToDto(jsonScu));
        }
        productDto.setScuDto(scuDtoList);
        return productDto;
    }

}
