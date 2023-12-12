package com.zoologico.main.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoologico.main.service.BBDDservicio;
@Controller
public class ImportacionController {
@Autowired
    private final BBDDservicio bbddServicios;

    public ImportacionController(BBDDservicio bbddServicios) {
        this.bbddServicios = bbddServicios;
    }

    @ResponseBody
    @GetMapping("/datosCSV")
    public String importarDatosCSV() throws SQLException {
        bbddServicios.servicioBBDD();
        return "Importación de datos CSV realizada2";
    }

}

//controladores servicios igual
//objeto con cada "tabla"
//repositorio base de datos
//controlador controla la llamada (siempre llama al servicio (no tiene "nada"))
//servicios todos los metodos que no tengan que ver con base de datos (si necesitamos ver base de datos se llama a repositorio)