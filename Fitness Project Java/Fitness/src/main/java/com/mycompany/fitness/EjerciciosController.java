/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author anto_
 */
@RestController
@RequestMapping("/api/ejercicios")
public class EjerciciosController {
    
    
    @Autowired
    private EjerciciosRepository ejercicioRepository;

    @GetMapping
    public List<Ejercicios> getEjerciciosPorObjetivo(@RequestParam String objetivo) {
        return ejercicioRepository.findByObjetivo(objetivo);
    }
    
    
}
