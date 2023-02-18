package com.softwaretesting.alienware.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public class ProductModel {

    @Id
//    @Column(name = "ProductId")
    private UUID ProductId;
//    @Column(name = "Name")
    private String Name;
//    @Column(name = "Detail")
    private String Detail;
//    @Column(name = "Price")
    private Float Price;
//    @Column(name = "Quantity")
    private Integer Quantity;
//    @Column(name = "IsActive")
    private Boolean IsActive;
//    @Column(name = "CreatedAt")
    private ZonedDateTime CreatedAt;
//    @Column(name = "UpdatedAt")
    private ZonedDateTime UpdatedAt;
//    @Column(name = "CreatedAt")
    private UUID CategoryId;
    @OneToOne(mappedBy = "CategoryName")
    private String CategoryName;

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
