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
public interface SesionesEntrenamientoRepository extends JpaRepository<SesionesEntrenamiento, Integer> {
    @Query(value = "SELECT se.*, ep1.nombre AS nombre_ejercicio1, ep1.repeticiones AS repeticiones_ejercicio1, ep1.duracion AS duracion_ejercicio1, " +
                   "ep2.nombre AS nombre_ejercicio2, ep2.repeticiones AS repeticiones_ejercicio2, ep2.duracion AS duracion_ejercicio2, " +
                   "ep3.nombre AS nombre_ejercicio3, ep3.repeticiones AS repeticiones_ejercicio3, ep3.duracion AS duracion_ejercicio3 " +
                   "FROM SesionesEntrenamiento se " +
                   "JOIN EjerciciosPracticados ep1 ON se.id_EjercicioPracticado1 = ep1.id_ejercicioPracticado " +
                   "JOIN EjerciciosPracticados ep2 ON se.id_EjercicioPracticado2 = ep2.id_ejercicioPracticado " +
                   "JOIN EjerciciosPracticados ep3 ON se.id_EjercicioPracticado3 = ep3.id_ejercicioPracticado " +
                   "JOIN Usuarios u ON se.id_usuario = u.id_usuario " +
                   "WHERE u.telefono = :telefono",
            nativeQuery = true)
    List<SesionesEntrenamiento> obtenerSesionesEntrenamientoPorTelefono(@Param("telefono") int telefono);
}
