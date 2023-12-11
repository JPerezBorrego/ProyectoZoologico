package com.zoologico.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoologico.main.repository.entities.Visitas;

@Repository
public interface VisitasRepository extends JpaRepository<Visitas, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
