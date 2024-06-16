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
public class EjerciciosPracticadosService {
    
    @Autowired
    private EjerciciosPracticadosRepository repository;

    public EjerciciosPracticados save(EjerciciosPracticados ejercicio) {
        return repository.save(ejercicio);
    }
    
}
