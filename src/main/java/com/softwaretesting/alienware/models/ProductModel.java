package com.softwaretesting.alienware.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ProductModel {

    private UUID ProductId;
    private String Name;
    private String Detail;
    private Float Price;
    private Integer Quantity;
    private Boolean IsActive;
    private ZonedDateTime CreatedAt;
    private ZonedDateTime UpdatedAt;
    private UUID CategoryId;
    private String CategoryName;

    public ProductModel(UUID productId, String name, String detail, Float price, Integer quantity, UUID categoryId, boolean isActive) {
        ProductId = productId;
        Name = name;
        Detail = detail;
        Price = price;
        Quantity = quantity;
        CategoryId = categoryId;
        IsActive = isActive;
    }

    public ProductModel(String name, String detail, Float price, Integer quantity, UUID categoryId) {
        Name = name;
        Detail = detail;
        Price = price;
        Quantity = quantity;
        CategoryId = categoryId;
    }

    public UUID getProductId() {
        return ProductId;
    }

    public void setProductId(UUID productId) {
        ProductId = productId;
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

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public ZonedDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    public UUID getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(UUID categoryId) {
        CategoryId = categoryId;
    }
}
