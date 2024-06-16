/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anto_
 */

@Service
public class SesionesEntrenamientoService {
    
     @Autowired
    private SesionesEntrenamientoRepository repository;

    public SesionesEntrenamiento save(SesionesEntrenamiento sesion) {
        return repository.save(sesion);
    }
    
}
