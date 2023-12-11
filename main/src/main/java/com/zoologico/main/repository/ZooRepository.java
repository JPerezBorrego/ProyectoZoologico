package com.zoologico.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoologico.main.repository.entities.Zoo;

@Repository
    // Si necesitas métodos adicionales, puedes agregarlos aquí si son necesarios
    public interface ZooRepository extends JpaRepository<Zoo, Long> {
   
    }
