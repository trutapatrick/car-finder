package com.example.carFinder.carFinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;

    @Column(name = "number_tracking")
    private String numberTracking;

    @Column(name = "address")
    private String address;

    @Column(name = "order_type")
    private String orderType;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<SecondHandCar> secondHandCars;

    @ManyToMany(mappedBy = "orderTire",cascade = CascadeType.ALL)
    private Set<Tire> tires;
}
