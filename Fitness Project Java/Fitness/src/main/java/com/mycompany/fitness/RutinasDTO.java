/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

/**
 *
 * @author anto_
 */
public class RutinasDTO {
    private Usuarios usuario;
    private Rutinas rutina;
    private Ejercicios ejercicio1;
    private Ejercicios ejercicio2;
    
    // Constructor, getters y setters

    public RutinasDTO(Usuarios usuario, Rutinas rutina, Ejercicios ejercicio1, Ejercicios ejercicio2) {
        this.usuario = usuario;
        this.rutina = rutina;
        this.ejercicio1 = ejercicio1;
        this.ejercicio2 = ejercicio2;
    }

  

    public Usuarios getUsuario() {
        return usuario;
    }

    public Rutinas getRutina() {
        return rutina;
    }

    public Ejercicios getEjercicio1() {
        return ejercicio1;
    }

    public Ejercicios getEjercicio2() {
        return ejercicio2;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void setRutina(Rutinas rutina) {
        this.rutina = rutina;
    }

    public void setEjercicio1(Ejercicios ejercicio1) {
        this.ejercicio1 = ejercicio1;
    }

    public void setEjercicio2(Ejercicios ejercicio2) {
        this.ejercicio2 = ejercicio2;
    }
    
    
}
