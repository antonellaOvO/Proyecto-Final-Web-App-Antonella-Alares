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




public interface AlimentosAgregadosRepository extends JpaRepository<AlimentosAgregados, Integer>  {
    @Query(value = "SELECT ua.*, u.* FROM AlimentosAgregados AS ua JOIN Usuarios AS u ON ua.id_usuario = u.id_usuario WHERE u.telefono = :telefono", nativeQuery = true)
List<AlimentosAgregados> obtenerFoodPlanningsPorTelefono(@Param("telefono") int telefono);
    }
