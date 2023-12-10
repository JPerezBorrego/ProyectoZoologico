package com.zoologico.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoologico.main.repository.entities.Animales;

@Repository
public interface AnimalRepository extends JpaRepository<Animales, Long> {
   List<Animales> findByNombre(String nombre);
} // Puedes agregar métodos personalizados si es necesario



