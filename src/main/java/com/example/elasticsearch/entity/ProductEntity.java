package com.example.elasticsearch.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_create")
    private LocalDateTime dateCreate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<SkuEntity> skuList = new ArrayList<>();

    public ProductEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<SkuEntity> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuEntity> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return '\n' + "{ \"index\" : {} }" + '\n' +
                "{" + '"' + "id" + '"' + ":" + id + "," +
                '"' + "name" + '"' + ":" + '"' + name + '"' + "," +
                '"' + "dateCreate" + '"' + ":" + '"' + dateCreate + '"' + "," +
                '"' + "skuList" + '"' + ":" + skuList + '}';
    }

    public String toStringJson() {
        return "{ \"index\" : {} }" + '\n' +
                "{" + '"' + "id" + '"' + ":" + id + "," +
                '"' + "name" + '"' + ":" + '"' + name + '"' + "," +
                '"' + "dateCreate" + '"' + ":" + '"' + dateCreate + '"' + "," +
                '"' + "scuDto" + '"' + ":" + skuList + '}';
    }
}
