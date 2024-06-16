/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author anto_
 */

@RestController
@RequestMapping("/api/sesiones")
public class SesionesEntrenamientoController {
    
    
    @Autowired
    private SesionesEntrenamientoService service;
    
     @Autowired
    private SesionesEntrenamientoRepository sesionesEntrenamientoRepository;

    @PostMapping
    public SesionesEntrenamiento save(@RequestBody SesionesEntrenamiento sesion) {
        return service.save(sesion);
    }
    
    @GetMapping("/por-telefono")
    public ResponseEntity<List<SesionesEntrenamiento>> obtenerSesionesEntrenamientoPorTelefono(@RequestParam int telefono) {
        List<SesionesEntrenamiento> sesiones = sesionesEntrenamientoRepository.obtenerSesionesEntrenamientoPorTelefono(telefono);
        if (sesiones.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(sesiones);
        }
    }
    
}
