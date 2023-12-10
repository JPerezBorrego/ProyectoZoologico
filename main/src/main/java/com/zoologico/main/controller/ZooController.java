package com.zoologico.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zoologico.main.repository.entities.Zoo;
import com.zoologico.main.service.ZooService;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    private final ZooService zooService;
    
    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping
    public List<Zoo> getAllZoos() {
        return zooService.getAllZoos();
    }

    @GetMapping("/{id}")
    public Zoo getZooById(@PathVariable Long id) {
        return zooService.getZooById(id);
    }

    @PostMapping
    public Zoo createZoo(@RequestBody Zoo zoo) {
        return zooService.createZoo(zoo);
    }

    @PutMapping("/{id}")
    public Zoo updateZoo(@PathVariable Long id, @RequestBody Zoo zoo) {
        return zooService.updateZoo(id, zoo);
    }

    @DeleteMapping("/{id}")
    public void deleteZoo(@PathVariable Long id) {
        zooService.deleteZoo(id);
    }
}
