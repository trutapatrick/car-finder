package com.example.carFinder.carFinder.repository;

import com.example.carFinder.carFinder.model.Tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TireRepository extends JpaRepository<Tire,Integer> {

    List<Tire> findAll();

    Optional<Tire> findTireById(Integer id);

    List<Tire> findTireByName(String name);
}
