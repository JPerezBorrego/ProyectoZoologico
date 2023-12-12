package com.zoologico.main.service;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoologico.main.repository.BBDDrepositorio;
@Service
public class BBDDservicio {
    @Autowired
    public BBDDrepositorio BBDDRepositorio;
    public void servicioBBDD() throws SQLException{
        BBDDRepositorio.importarDatosCSV();
    
    }
}
