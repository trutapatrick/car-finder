package com.example.carFinder.carFinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "second_hand_car")
public class SecondHandCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_second_hand_car")
    private int id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "first_registration")
    private int firstRegistration;

    @Column(name = "mileage")
    private String mileage;

    @Column(name = "price")
    private double price;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "power")
    private String power;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "colour")
    private String colour;

    @Column(name="car_image")
    private String carImage;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="secondHandCar_to_order")
    private Set<Order> orders;
}
