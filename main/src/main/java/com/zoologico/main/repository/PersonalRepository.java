package com.zoologico.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoologico.main.repository.entities.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
    // Puedes añadir métodos adicionales personalizados aquí si es necesario
}

