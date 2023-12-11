package com.zoologico.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.xstream.XStream;
import com.zoologico.main.repository.AnimalRepository;
import com.zoologico.main.repository.entities.Animales;
import com.zoologico.main.repository.entities.Habitat;
import com.zoologico.main.repository.entities.Personal;
import com.zoologico.main.service.AnimalesService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/ExportarAnimales")
public class AnimalesControllerExportar {
    @Autowired
    private  AnimalesService animalService;

   

    @GetMapping
    public String getAllAnimals() {
        List<Animales> animals = animalService.getAllAnimals();

        // Configuración de XStream
        XStream xStream = new XStream();
        xStream.alias("animal", Animales.class);
        xStream.alias("Habitat", Habitat.class);
        xStream.alias("Personal", Personal.class);
        // Convertir la lista de animales a XML
        String xml = xStream.toXML(animals);

        // Guardar la cadena XML en un archivo
        try (FileWriter fileWriter = new FileWriter("animales.xml")) {
            fileWriter.write(xml);
            return "Datos de animales guardados en animales.xml";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar datos en XML";
        }
    }
}
