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
@Table(name = "tire")
public class Tire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tire")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "season")
    private String season;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "diameter")
    private int diameter;

    @Column(name="tire_image")
    private String tireImage;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tire_to_order")
    private Set<Order> orderTire;
}
