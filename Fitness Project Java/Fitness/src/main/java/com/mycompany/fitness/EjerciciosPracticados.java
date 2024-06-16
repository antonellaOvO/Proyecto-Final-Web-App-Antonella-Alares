/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author anto_
 */

@Entity
public class EjerciciosPracticados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicioPracticado")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "repeticiones")
    private int repeticiones;
    @Column(name = "duracion")
    private double duracion;
   
    
      public EjerciciosPracticados() {
    }
    
    
    
    //GETTERS

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public double getDuracion() {
        return duracion;
    }
      
      
    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
      
      
  
}
