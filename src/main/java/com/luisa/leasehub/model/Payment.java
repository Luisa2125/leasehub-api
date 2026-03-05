package com.luisa.leasehub.model;

import com.luisa.leasehub.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private Double amount;
    @Column
    private String paymentDate;
    @Column
    private Status status;
    @ManyToOne()
    private Lease lease;

    public Payment(Double amount, String paymentDate, Status status, Lease lease) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.lease = lease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }
}
