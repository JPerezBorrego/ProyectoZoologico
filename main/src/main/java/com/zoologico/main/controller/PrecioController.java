package com.zoologico.main.controller;

import org.springframework.web.bind.annotation.*;

import com.zoologico.main.repository.entities.Precio;
import com.zoologico.main.service.PrecioService;

import java.util.List;

@RestController
@RequestMapping("/precios")
public class PrecioController {

    private final PrecioService precioService;

    public PrecioController(PrecioService precioService) {
        this.precioService = precioService;
    }

    @GetMapping
    public List<Precio> getAllPrecios() {
        return precioService.getAllPrecios();
    }

    @GetMapping("/{id}")
    public Precio getPrecioById(@PathVariable Long id) {
        return precioService.getPrecioById(id);
    }

    @PostMapping
    public Precio createPrecio(@RequestBody Precio precio) {
        return precioService.createPrecio(precio);
    }

    @PutMapping("/{id}")
    public Precio updatePrecio(@PathVariable Long id, @RequestBody Precio precio) {
        return precioService.updatePrecio(id, precio);
    }

    @DeleteMapping("/{id}")
    public void deletePrecio(@PathVariable Long id) {
        precioService.deletePrecio(id);
    }
}
