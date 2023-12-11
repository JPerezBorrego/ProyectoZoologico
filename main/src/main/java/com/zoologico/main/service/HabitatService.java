package com.zoologico.main.service;

import org.springframework.stereotype.Service;
import com.zoologico.main.repository.HabitatRepository;
import com.zoologico.main.repository.entities.Habitat;
import java.util.List;

@Service
public class HabitatService {

    private final HabitatRepository habitatRepository;

    public HabitatService(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    public List<Habitat> getAllHabitats() {
        return habitatRepository.findAll();
    }

    public Habitat getHabitatById(Long id) {
        return habitatRepository.findById(id).orElse(null);
    }
  

    public Habitat createHabitat(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    public Habitat updateHabitat(Long id, Habitat updatedHabitat) {
        Habitat existingHabitat = habitatRepository.findById(id).orElse(null);
        if (existingHabitat != null) {
            existingHabitat.setNombre(updatedHabitat.getNombre());
            existingHabitat.setTipo(updatedHabitat.getTipo());
            // Actualizar otros campos si es necesario
            return habitatRepository.save(existingHabitat);
        }
        return null;
    }

    public void deleteHabitat(Long id) {
        habitatRepository.deleteById(id);
    }
}
