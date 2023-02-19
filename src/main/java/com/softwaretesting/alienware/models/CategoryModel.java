package com.softwaretesting.alienware.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;


//@Entity
//@Table(name = "Categories",
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"Name"})}
//)
@Component
public class CategoryModel {

//    @Id
//    @Column(name = "CategoryId", columnDefinition = "uuid NOT NULL DEFAULT uuid_generate_v4()")
    private UUID id;
//    @Column(name = "Name", columnDefinition = "character varying(100) COLLATE pg_catalog.\"default\" NOT NULL")
    private String categoryName;
//    @Column(name = "CreatedAt", columnDefinition = "timestamp with time zone DEFAULT now()")
    private LocalDate createdAt;

//    @Column(name = "UpdatedAt" , columnDefinition = "timestamp with time zone DEFAULT now()")
    private LocalDate updatedAt;

    public CategoryModel() {
    }

    public CategoryModel(UUID id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public CategoryModel(
                         @JsonProperty("categoryName")String categoryName
                         ) {
        this.categoryName = categoryName;
        this.createdAt = LocalDate.now();
        this.updatedAt = null;
    }

    public UUID getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
}


