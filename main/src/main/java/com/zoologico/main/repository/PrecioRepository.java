package com.zoologico.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoologico.main.repository.entities.Precio;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
