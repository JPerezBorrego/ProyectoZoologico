package com.zoologico.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.xstream.XStream;
import com.zoologico.main.repository.entities.Personal;
import com.zoologico.main.repository.entities.Visitas;
import com.zoologico.main.service.VisitaService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/ExportarVisitas")
public class VisitasControladorExporter {
    
    @Autowired
    private  VisitaService visitasService;

   

    @GetMapping
    public String getAllPersonalString() {
        visitasService.getAllVisitas();
        List<Visitas> listavisitas = visitasService.getAllVisitas();
        // Configuración de XStream
        XStream xStream = new XStream();
        xStream.alias("visitas", Personal.class);

        // Convertir la lista de personal a XML
        String xml = xStream.toXML(listavisitas);

        // Guardar la cadena XML en un archivo
        try (FileWriter fileWriter = new FileWriter("Visitas.xml")) {
            fileWriter.write(xml);
            return "Datos de personal guardados en Personal.xml";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar datos en XML";
        }
    }
}