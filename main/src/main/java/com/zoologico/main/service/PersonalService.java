package com.zoologico.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoologico.main.repository.PersonalRepository;
import com.zoologico.main.repository.entities.Personal;

@Service
public class PersonalService {

    private final PersonalRepository personalRepository;

    
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public static List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }

    public Personal getPersonalById(Long id) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        return optionalPersonal.orElse(null);
    }

    public Personal addPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    public Personal updatePersonal(Long id, Personal newPersonalData) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        if (optionalPersonal.isPresent()) {
            Personal existingPersonal = optionalPersonal.get();
            // Actualizar los campos necesarios
            // por ejemplo: existingPersonal.setNombre(newPersonalData.getNombre());
            return personalRepository.save(existingPersonal);
        }
        return null;
    }

    public void deletePersonal(Long id) {
        personalRepository.deleteById(id);
    }
}
