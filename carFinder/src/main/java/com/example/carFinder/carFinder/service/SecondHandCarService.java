package com.example.carFinder.carFinder.service;

import com.example.carFinder.carFinder.model.SecondHandCar;

import java.util.List;
import java.util.Optional;

public interface SecondHandCarService {

    List<SecondHandCar> getAllSecondHandCar();

    Optional<SecondHandCar> getSecondHandCarByMake(String make);

    Optional<SecondHandCar> getSecondHandCarById(Integer id);

    SecondHandCar updateSecondHandCar(SecondHandCar secondHandCar);

    SecondHandCar addSecondHandCar(SecondHandCar secondHandCar);

    void deleteSecondHandCar(Integer id);
}
