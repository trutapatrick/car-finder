package com.example.carFinder.carFinder.service;

import com.example.carFinder.carFinder.model.SecondHandCar;
import com.example.carFinder.carFinder.repository.SecondHandCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecondHandCarServiceImpl implements SecondHandCarService {

    @Autowired
    private SecondHandCarRepository secondHandCarRepository;


    @Override
    public List<SecondHandCar> getAllSecondHandCar() {
        return secondHandCarRepository.findAll();
    }

    @Override
    public Optional<SecondHandCar> getSecondHandCarById(Integer id) {
        Optional<SecondHandCar> car = secondHandCarRepository.findSecondHandCarById(id);
        if (!car.isPresent()) {
            throw new IllegalArgumentException("Car not found !");
        }
        return car;
    }


    @Override
    public Optional<SecondHandCar> getSecondHandCarByMake(String make) {
        Optional<SecondHandCar> secondHandCarOptional = secondHandCarRepository.findSecondHandCarByMake(make);
        if (secondHandCarOptional.isPresent()) {
            throw new IllegalArgumentException("Second hand car not found !");
        }
        return secondHandCarOptional;
    }


    @Override
    public SecondHandCar updateSecondHandCar(SecondHandCar secondHandCar) {
        Optional<SecondHandCar> searchedCarById = secondHandCarRepository.findSecondHandCarById(secondHandCar.getId());
        if (!searchedCarById.isPresent()) {
            throw new IllegalArgumentException("This car was not found");
        }
        return secondHandCarRepository.save(secondHandCar);
    }

    @Override
    public SecondHandCar addSecondHandCar(SecondHandCar secondHandCar) {
        Optional<SecondHandCar> searchedCarById = secondHandCarRepository.findSecondHandCarById(secondHandCar.getId());
        if (searchedCarById.isPresent()) {
            throw new IllegalArgumentException("This car already exists !");
        }
        return secondHandCarRepository.save(secondHandCar);
    }

    @Override
    public void deleteSecondHandCar(Integer id) {
        Optional<SecondHandCar> optionalSecondHandCar = secondHandCarRepository.findSecondHandCarById(id);
        if (!optionalSecondHandCar.isPresent()) {
            throw new IllegalArgumentException("This car doesn't exist ! ");
        }
        secondHandCarRepository.deleteById(id);
    }
}
