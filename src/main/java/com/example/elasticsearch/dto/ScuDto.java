package com.example.elasticsearch.dto;

public class ScuDto {
    private String colour;
    private Double size;
    private String supplier;

    private Long id;

    private boolean isAvailability;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailability() {
        return isAvailability;
    }

    public void setAvailability(boolean availability) {
        isAvailability = availability;
    }

    @Override
    public String toString() {
        return "ScuDto{" +
                "colour='" + colour + '\'' +
                ", size=" + size +
                ", supplier='" + supplier + '\'' +
                ", id=" + id +
                ", isAvailability=" + isAvailability +
                '}';
    }
}