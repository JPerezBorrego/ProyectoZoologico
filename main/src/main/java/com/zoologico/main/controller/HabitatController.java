package com.zoologico.main.controller;

import org.springframework.web.bind.annotation.*;

import com.zoologico.main.repository.entities.Habitat;
import com.zoologico.main.service.HabitatService;

import java.util.List;

@RestController
@RequestMapping("/habitats")
public class HabitatController {

    private final HabitatService habitatService;

    public HabitatController(HabitatService habitatService) {
        this.habitatService = habitatService;
    }

    @GetMapping
    public List<Habitat> getAllHabitats() {
        return habitatService.getAllHabitats();
    }

    @GetMapping("/{id}")
    public Habitat getHabitatById(@PathVariable Long id) {
        return habitatService.getHabitatById(id);
    }

    @PostMapping
    public Habitat createHabitat(@RequestBody Habitat habitat) {
        return habitatService.createHabitat(habitat);
    }

    @PutMapping("/{id}")
    public Habitat updateHabitat(@PathVariable Long id, @RequestBody Habitat habitat) {
        return habitatService.updateHabitat(id, habitat);
    }

    @DeleteMapping("/{id}")
    public void deleteHabitat(@PathVariable Long id) {
        habitatService.deleteHabitat(id);
    }
}
