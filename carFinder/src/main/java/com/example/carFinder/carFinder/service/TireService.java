package com.example.carFinder.carFinder.service;

import com.example.carFinder.carFinder.model.Tire;

import java.util.List;
import java.util.Optional;

public interface TireService {

    List<Tire> getAllTires();

    Optional<Tire> getTireById(Integer id);

   Tire updateTire(Tire tire);

    Tire addTire(Tire tire);

    void deleteTire(Integer id);
}
