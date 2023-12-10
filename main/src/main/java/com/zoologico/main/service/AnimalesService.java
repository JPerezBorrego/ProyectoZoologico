package com.zoologico.main.service;


import org.springframework.stereotype.Service;

import com.zoologico.main.repository.AnimalRepository;
import com.zoologico.main.repository.entities.Animales;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalesService {

    private final AnimalRepository animalRepository;

    public AnimalesService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animales> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animales getAnimalesById(Long animalId) {
        Optional<Animales> optionalAnimal = animalRepository.findById(animalId);
        return optionalAnimal.orElse(null);
    }

    public List<Animales> obtenerAnimalesPorNombre(String nombre) {
        return animalRepository.findByNombre(nombre);
    }
}


