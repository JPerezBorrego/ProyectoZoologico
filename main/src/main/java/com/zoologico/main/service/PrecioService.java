package com.zoologico.main.service;
import org.springframework.stereotype.Service;

import com.zoologico.main.repository.PrecioRepository;
import com.zoologico.main.repository.entities.Precio;

import java.util.List;

@Service
public class PrecioService {

    private final PrecioRepository precioRepository;

    
    public PrecioService(PrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    public List<Precio> getAllPrecios() {
        return precioRepository.findAll();
    }

    public Precio getPrecioById(Long id) {
        return precioRepository.findById(id).orElse(null);
    }

    public Precio createPrecio(Precio precio) {
        return precioRepository.save(precio);
    }

    public Precio updatePrecio(Long id, Precio precio) {
        if (precioRepository.existsById(id)) {
            precio.setIdPrecio(id);
            return precioRepository.save(precio);
        }
        return null;
    }

    public void deletePrecio(Long id) {
        precioRepository.deleteById(id);
    }
}
