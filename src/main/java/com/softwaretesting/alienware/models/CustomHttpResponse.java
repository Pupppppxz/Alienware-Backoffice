package com.softwaretesting.alienware.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomHttpResponse {

    @JsonProperty("data")
    private Objects data;

    @JsonProperty("statusCode")
    private Integer statusCode;

    @JsonProperty("message")
    private String message;

    CustomHttpResponse(String message, Integer statusCode, Objects data) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public CustomHttpResponse(String message, Integer statusCode) {
        this.data = null;
        this.message = message;
        this.statusCode = statusCode;
    }

    public Objects getData() {
        return data;
    }

    public void setData(Objects data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
