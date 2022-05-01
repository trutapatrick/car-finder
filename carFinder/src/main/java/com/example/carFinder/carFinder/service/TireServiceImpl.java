package com.example.carFinder.carFinder.service;

import com.example.carFinder.carFinder.model.Tire;
import com.example.carFinder.carFinder.repository.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TireServiceImpl implements TireService{

    @Autowired
    private TireRepository tireRepository;

    @Override
    public List<Tire> getAllTires() {
        return tireRepository.findAll();
    }

    @Override
    public Optional<Tire> getTireById(Integer id) {
        Optional<Tire> tire = tireRepository.findTireById(id);
        if(!tire.isPresent()){
            throw new IllegalArgumentException("Tire not found!");
        }
        return tire;
    }

    @Override
    public Tire updateTire(Tire tire) {
        Optional<Tire> searchedTireById = tireRepository.findTireById(tire.getId());
        if(!searchedTireById.isPresent()){
            throw new IllegalArgumentException("Tire was not found !");
        }
        return tireRepository.save(tire);
    }

    @Override
    public Tire addTire(Tire tire) {
        Optional<Tire> searchedTireById = tireRepository.findTireById(tire.getId());
        if(searchedTireById.isPresent()){
            throw new IllegalArgumentException("Tire already exists !");
        }
        return tireRepository.save(tire);
    }

    @Override
    public void deleteTire(Integer id) {
        Optional<Tire> tireOptional = tireRepository.findTireById(id);
        if (!tireOptional.isPresent()){
            throw new IllegalArgumentException("Tire doesn't exist !");
        }
        tireRepository.deleteById(id);
    }
}
