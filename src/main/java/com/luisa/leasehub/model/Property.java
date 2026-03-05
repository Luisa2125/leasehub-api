package com.luisa.leasehub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "property")
@Data
public class Property {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String postcode;
    @Column
    private Double rentAmount;
    @Column
    private String createdAt;
    @ManyToOne()
    private User user;

    protected Property() {

    }

    public Property(String title, String description, String address, String city, String state, String postcode, Double rentAmount, String createdAt, User user) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.rentAmount = rentAmount;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
