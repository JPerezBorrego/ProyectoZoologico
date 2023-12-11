package com.zoologico.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoologico.main.repository.entities.Habitat;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {
    // Puedes agregar métodos personalizados si necesitas consultas específicas
}
