/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author anto_
 */

@RestController
@RequestMapping("/api/ejerciciosPracticados")
public class EjerciciosPracticadosController {
    
    @Autowired
    private EjerciciosPracticadosService service;

    @PostMapping
    public EjerciciosPracticados save(@RequestBody EjerciciosPracticados ejercicio) {
        return service.save(ejercicio);
    }
    
}
