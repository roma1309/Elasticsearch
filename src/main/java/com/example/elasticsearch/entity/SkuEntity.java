package com.example.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "sku")
public class SkuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supplier;
    private String colour;
    @Column(name = "is_availability")
    private boolean isAvailability;
    private double size;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public SkuEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public boolean isAvailability() {
        return isAvailability;
    }

    public void setAvailability(boolean availability) {
        isAvailability = availability;
    }

    @Override
    public String toString() {
        return "{" +
                '"' + "id" + '"' + ":" + id + "," +
                '"' + "supplier" + '"' + ":" + '"' + supplier + '"' + "," +
                '"' + "isAvailability" + '"' + ":" + isAvailability + "," +
                '"' + "colour" + '"' + ":" + '"' + colour + '"' + "," +
                '"' + "size" + '"' + ":" + size +
                '}';
    }
}
