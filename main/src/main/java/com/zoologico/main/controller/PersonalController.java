package com.zoologico.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoologico.main.repository.entities.Personal;
import com.zoologico.main.service.PersonalService;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalService.getAllPersonal();
    }

    @GetMapping("/{id}")
    public Personal getPersonalById(@PathVariable Long id) {
        return personalService.getPersonalById(id);
    }

    @PostMapping
    public Personal addPersonal(@RequestBody Personal personal) {
        return personalService.addPersonal(personal);
    }

    @PutMapping("/{id}")
    public Personal updatePersonal(@PathVariable Long id, @RequestBody Personal personal) {
        return personalService.updatePersonal(id, personal);
    }

    @DeleteMapping("/{id}")
    public void deletePersonal(@PathVariable Long id) {
        personalService.deletePersonal(id);
    }
}

