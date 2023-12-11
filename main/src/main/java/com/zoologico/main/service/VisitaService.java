package com.zoologico.main.service;

import org.springframework.stereotype.Service;

import com.zoologico.main.repository.VisitasRepository;
import com.zoologico.main.repository.entities.Visitas;

import java.util.List;

@Service
public class VisitaService {

    private final VisitasRepository visitaRepository;

    public VisitaService(VisitasRepository visitaRepository) {
        this.visitaRepository = visitaRepository;
    }

    public List<Visitas> getAllVisitas() {
        return visitaRepository.findAll();
    }

    public Visitas getVisitaById(Long id) {
        return visitaRepository.findById(id).orElse(null);
    }

    public Visitas createVisita(Visitas visita) {
        return visitaRepository.save(visita);
    }

    public Visitas updateVisita(Long id, Visitas visita) {
        if (visitaRepository.existsById(id)) {
            visita.setId(id);
            return visitaRepository.save(visita);
        }
        return null; // O lanza una excepción, dependiendo del manejo de errores requerido.
    }

    public void deleteVisita(Long id) {
        visitaRepository.deleteById(id);
    }
}
