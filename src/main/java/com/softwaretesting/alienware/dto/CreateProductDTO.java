package com.softwaretesting.alienware.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CreateProductDTO {
    private String Name;
    private String Detail;
    private Float Price;
    private Integer Quantity;
    private UUID CategoryId;

    public CreateProductDTO(String name, String detail, Float price, Integer quantity, UUID categoryId) {
        Name = name;
        Detail = detail;
        Price = price;
        Quantity = quantity;
        CategoryId = categoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public UUID getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(UUID categoryId) {
        CategoryId = categoryId;
    }
}
