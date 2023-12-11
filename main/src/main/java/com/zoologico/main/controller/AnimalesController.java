package com.zoologico.main.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoologico.main.repository.entities.Animales;
import com.zoologico.main.service.AnimalesService;
@Controller
@RestController
@RequestMapping("/TodosLosAnimales")
public class AnimalesController {

    private final AnimalesService animalService;

    public AnimalesController(AnimalesService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animales> getAllAnimals() {
        return animalService.getAllAnimals();
    }
//Ver animal por ID
   @GetMapping("/animal/{animalId}")
public ResponseEntity<Animales> getAnimalById(@PathVariable Long animalId) {
    Animales animal = animalService.getAnimalesById(animalId);
    if (animal != null) {
        return ResponseEntity.ok(animal);
    } else {
        return ResponseEntity.notFound().build();
    }
}
//Ver animales por nombre
@GetMapping("/animal/nombre/{nombre}")
public List<Animales> obtenerAnimalesPorNombre(@PathVariable String nombre) {
    return animalService.obtenerAnimalesPorNombre(nombre);
}
}

