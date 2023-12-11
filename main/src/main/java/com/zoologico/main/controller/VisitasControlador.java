package com.zoologico.main.controller;

import org.springframework.web.bind.annotation.*;

import com.zoologico.main.repository.entities.Visitas;
import com.zoologico.main.service.VisitaService;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitasControlador {

    private final VisitaService visitaService;

    public VisitasControlador(VisitaService visitaService) {
        this.visitaService = visitaService;
    }

    @GetMapping
    public List<Visitas> getAllVisitas() {
        return visitaService.getAllVisitas();
    }

    @GetMapping("/{id}")
    public Visitas getVisitaById(@PathVariable Long id) {
        return visitaService.getVisitaById(id);
    }

    @PostMapping
    public Visitas createVisita(@RequestBody Visitas visita) {
        return visitaService.createVisita(visita);
    }

    @PutMapping("/{id}")
    public Visitas updateVisita(@PathVariable Long id, @RequestBody Visitas visita) {
        return visitaService.updateVisita(id, visita);
    }

    @DeleteMapping("/{id}")
    public void deleteVisita(@PathVariable Long id) {
        visitaService.deleteVisita(id);
    }
}
