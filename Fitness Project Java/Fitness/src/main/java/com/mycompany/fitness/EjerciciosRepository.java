/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author anto_
 */
public interface EjerciciosRepository extends JpaRepository<Ejercicios, Integer> {
    List<Ejercicios> findByObjetivo(String objetivo);
}
