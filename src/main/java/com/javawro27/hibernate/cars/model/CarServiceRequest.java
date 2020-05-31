package com.javawro27.hibernate.cars.model;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
public class CarServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double amount;

    @CreationTimestamp
    private LocalDateTime created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRepair;

    public CarServiceRequest(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}
