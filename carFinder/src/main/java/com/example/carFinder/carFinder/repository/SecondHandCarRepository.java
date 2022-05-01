package com.example.carFinder.carFinder.repository;

import com.example.carFinder.carFinder.model.SecondHandCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecondHandCarRepository extends JpaRepository<SecondHandCar, Integer> {

    List<SecondHandCar>findAll();

    Optional<SecondHandCar> findSecondHandCarById(Integer id);

    Optional<SecondHandCar> findSecondHandCarByMake(String make);



}
