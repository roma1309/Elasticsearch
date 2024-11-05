package com.example.elasticsearch.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ProductDto {
    private Long id;
    private String name;
    private String dateCreate;

    private List<ScuDto> scuList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDateTime getDateCreate() {
//        return dateCreate;
//    }
//
//    public void setDateCreate(LocalDateTime dateCreate) {
//        this.dateCreate = dateCreate;
//    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }


    public List<ScuDto> getScuList() {
        return scuList;
    }

    public void setScuList(List<ScuDto> scuList) {
        this.scuList = scuList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", scuList=" + scuList +
                '}';
    }
}
