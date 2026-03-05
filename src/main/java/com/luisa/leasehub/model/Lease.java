package com.luisa.leasehub.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "lease")
public class Lease {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String startDate;
    @Column
    private String endDate;
    @Column
    private Double monthlyRent;
    @Column
    private Double bondAmount;
    @Column
    private Boolean active;
    @ManyToOne()
    private Property property;
    @ManyToOne()
    private User tenant;

    protected Lease () {

    }

    public Lease(String startDate, String endDate, Double monthlyRent, Double bondAmount, Boolean active, Property property, User tenant) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRent = monthlyRent;
        this.bondAmount = bondAmount;
        this.active = active;
        this.property = property;
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Double getBondAmount() {
        return bondAmount;
    }

    public void setBondAmount(Double bondAmount) {
        this.bondAmount = bondAmount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }
}
