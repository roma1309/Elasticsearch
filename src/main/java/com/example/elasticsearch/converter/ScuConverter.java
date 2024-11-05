package com.example.elasticsearch.converter;

import com.example.elasticsearch.dto.ProductDto;
import com.example.elasticsearch.dto.ScuDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class ScuConverter {

    public static ScuDto jsonToDto(JsonElement jsonObject) {
        ScuDto scuDto = new ScuDto();
        Gson gson = new Gson();
        scuDto = gson.fromJson(jsonObject.getAsJsonObject(), ScuDto.class);
        return scuDto;
    }
}
