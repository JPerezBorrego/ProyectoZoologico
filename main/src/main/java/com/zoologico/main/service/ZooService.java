package com.zoologico.main.service;

import org.springframework.stereotype.Service;

import com.zoologico.main.repository.ZooRepository;
import com.zoologico.main.repository.entities.Zoo;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

    private final ZooRepository zooRepository;

    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public List<Zoo> getAllZoos() {
        return zooRepository.findAll();
    }

    public Zoo getZooById(Long id) {
        Optional<Zoo> zoo = zooRepository.findById(id);
        return zoo.orElse(null); // O lanza una excepción si es más adecuado
    }

    public Zoo createZoo(Zoo zoo) {
        // Lógica adicional, si es necesaria, antes de guardar
        return zooRepository.save(zoo);
    }

    public Zoo updateZoo(Long id, Zoo zooDetails) {
        Optional<Zoo> optionalZoo = zooRepository.findById(id);
        if (optionalZoo.isPresent()) {
            Zoo existingZoo = optionalZoo.get();
            // Actualizar los campos necesarios
            existingZoo.setNombre(zooDetails.getNombre());
            existingZoo.setDireccion(zooDetails.getDireccion());
            // Actualizar otros campos si es necesario

            return zooRepository.save(existingZoo);
        } else {
            return null; // O lanza una excepción si es más adecuado
        }
    }

    public void deleteZoo(Long id) {
        zooRepository.deleteById(id);
    }
}
