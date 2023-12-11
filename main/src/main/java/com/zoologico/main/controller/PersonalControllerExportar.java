package com.zoologico.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.xstream.XStream;
import com.zoologico.main.repository.entities.Personal;
import com.zoologico.main.service.PersonalService;

import java.io.FileWriter;
import java.io.IOException;
@RestController
@RequestMapping("/ExportarPersonal")
public class PersonalControllerExportar {
    private static final Object Personal = null;
    @Autowired
    private  PersonalService animalService;

   

    @GetMapping
    public String getAllPersonalString() {
        PersonalService.getAllPersonal();

        // Configuración de XStream
        XStream xStream = new XStream();
        xStream.alias("Personal", Personal.class);

        // Convertir la lista de personal a XML
        String xml = xStream.toXML(Personal);

        // Guardar la cadena XML en un archivo
        try (FileWriter fileWriter = new FileWriter("Personal.xml")) {
            fileWriter.write(xml);
            return "Datos de personal guardados en Personal.xml";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar datos en XML";
        }
    }
}
