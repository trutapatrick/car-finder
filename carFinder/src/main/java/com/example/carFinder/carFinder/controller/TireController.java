package com.example.carFinder.carFinder.controller;

import com.example.carFinder.carFinder.model.Order;
import com.example.carFinder.carFinder.model.Tire;
import com.example.carFinder.carFinder.service.TireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/tires")
@Controller
public class TireController {

    @Autowired
    private TireServiceImpl tireServiceImpl;

    @GetMapping("/allTires")
    public ResponseEntity<List<Tire>> getAllTires() {
        List<Tire> tiresList = tireServiceImpl.getAllTires();
        return new ResponseEntity<>(tiresList, HttpStatus.OK);
    }

    @GetMapping("/tire/{id}")
    public ResponseEntity<Optional<Tire>> getTireById(@PathVariable Integer id) {
        try {
            Optional<Tire> tire = tireServiceImpl.getTireById(id);
            return new ResponseEntity<>(tire, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createTire")
    public ResponseEntity<Tire> createTire(@RequestBody Tire tire) {
        Tire newTire = tireServiceImpl.addTire(tire);
        return new ResponseEntity<>(newTire, HttpStatus.CREATED);
    }


    @PutMapping("/updateTire/{id}")
    public ResponseEntity<Tire> updateTire(@RequestBody Tire tire, @PathVariable(value = "id") Integer id) {
        Optional <Tire> tireFromDB = tireServiceImpl.getTireById(id);
        tireFromDB.get().setId(tire.getId());
        tireFromDB.get().setName(tire.getName());
        tireFromDB.get().setPrice(tire.getPrice());
        tireFromDB.get().setSeason(tire.getSeason());
        tireFromDB.get().setVehicleType(tire.getVehicleType());
        tireFromDB.get().setWidth(tire.getWidth());
        tireFromDB.get().setHeight(tire.getHeight());
        tireFromDB.get().setDiameter(tire.getDiameter());
        tireServiceImpl.updateTire(tireFromDB.get());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @DeleteMapping("/deleteTire/{id}")
    public ResponseEntity<Tire> deleteTire(@PathVariable Integer id) {
        try {
            tireServiceImpl.deleteTire(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
