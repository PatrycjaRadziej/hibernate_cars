package com.javawro27.hibernate.cars.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table()
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String registrationNumber;


    private double engineCapacity;
    private boolean forPetrol;

    @Enumerated(value = EnumType.STRING)
    private Colour colour;

    @Enumerated(value = EnumType.STRING)
    private Model model;



}
