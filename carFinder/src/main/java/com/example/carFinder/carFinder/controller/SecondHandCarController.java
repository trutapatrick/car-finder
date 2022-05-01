package com.example.carFinder.carFinder.controller;

import com.example.carFinder.carFinder.model.SecondHandCar;
import com.example.carFinder.carFinder.service.SecondHandCarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/cars")
@Controller
public class SecondHandCarController {

    @Autowired
    private SecondHandCarServiceImpl secondHandCarServiceImpl;

    @GetMapping("/allCars")
    public ResponseEntity<List<SecondHandCar>> getAllSecondHandCar() {
        List<SecondHandCar> secondHandCarList = secondHandCarServiceImpl.getAllSecondHandCar();
        return new ResponseEntity<>(secondHandCarList, HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Optional<SecondHandCar>> getSecondHandCarById(@PathVariable(value = "id") Integer id) {
        try {
            Optional<SecondHandCar> shCar = secondHandCarServiceImpl.getSecondHandCarById(id);
            return new ResponseEntity<>(shCar, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addCar")
    public ResponseEntity<SecondHandCar> addSecondHandCar(@RequestBody SecondHandCar secondHandCar) {
        SecondHandCar newCar = secondHandCarServiceImpl.addSecondHandCar(secondHandCar);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/updateCar")
    public ResponseEntity<SecondHandCar> updateSecondHandCar(@RequestBody SecondHandCar secondHandCar) {
        SecondHandCar handCar = secondHandCarServiceImpl.updateSecondHandCar(secondHandCar);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(handCar);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SecondHandCar> deleteSecondHandCar(@PathVariable Integer id) {
        try {
            secondHandCarServiceImpl.deleteSecondHandCar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
