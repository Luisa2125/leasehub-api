package com.luisa.leasehub.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PropertyRequest {
    @NotBlank(message = "Title must no be empty")
    @Size(max = 50, message = "Title cannot exceed 50 characters")
    private String title;
    @NotBlank(message = "Description must no be empty")
    private String description;
    @NotBlank(message = "Address must no be empty")
    private String address;
    @NotBlank(message = "City must no be empty")
    private String city;
    @NotBlank(message = "State must no be empty")
    private String state;
    @NotBlank(message = "postcode must no be empty")
    private String postcode;
    @NotNull(message = "Rent amount must no be empty")
    private Double rentAmount;
    private Long userId;

    public PropertyRequest(String title, String description, String address, String city, String state, String postcode, Double rentAmount, Long userId) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.rentAmount = rentAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
