/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitness;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author anto_
 */
public interface RutinasRepository extends JpaRepository<Rutinas, Integer>{
    
    @Query("SELECT new com.mycompany.fitness.RutinasDTO(u, r, e1, e2) " +
           "FROM Usuarios u " +
           "JOIN Rutinas r ON u.id = r.usuario.id " +
           "LEFT JOIN Ejercicios e1 ON r.ejercicio1.id = e1.id " +
           "LEFT JOIN Ejercicios e2 ON r.ejercicio2.id = e2.id " +
           "WHERE u.telefono = :telefono")
    List<RutinasDTO> obtenerRutinasUsuarioPorTelefono(@Param("telefono") int telefono);
    
   
    
    
}
