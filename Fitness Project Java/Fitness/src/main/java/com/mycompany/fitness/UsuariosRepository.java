/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitness;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 *
 * @author anto_
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    Optional<Usuarios> findByTelefono(int telefono);
    
    @Query(value = "SELECT COUNT(*) FROM Rutinas r WHERE r.id_usuario = :userId", nativeQuery = true)
    int countRutinasByUsuarioId(@Param("userId")int userId);

    @Query(value ="SELECT COUNT(*) FROM SesionesEntrenamiento s WHERE s.id_usuario= :userId", nativeQuery = true)
    int countEntrenamientosByUsuarioId(@Param("userId")int userId);
    
    @Query(value ="SELECT COUNT(DISTINCT nombre_planning) FROM AlimentosAgregados WHERE id_usuario = :userId", nativeQuery = true)
    int countFoodPlanningsByUsuarioId(@Param("userId")int userId);
}
