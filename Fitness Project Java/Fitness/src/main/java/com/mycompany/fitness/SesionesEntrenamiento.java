/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author anto_
 */

@Entity
public class SesionesEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private int idSesion;
    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_EjercicioPracticado1")
    private EjerciciosPracticados ejercicio1;

    @ManyToOne
    @JoinColumn(name = "id_EjercicioPracticado2")
    private EjerciciosPracticados ejercicio2;

    @ManyToOne
    @JoinColumn(name = "id_EjercicioPracticado3")
    private EjerciciosPracticados ejercicio3;
    
    @Column(name = "fechaCreacion_sesion")
    private LocalDateTime fechaCreacion;
    
    
    
    
    /*La anotación @PrePersist es una anotación de JPA (Java Persistence API) 
    utilizada para marcar un método en una entidad que debe ejecutarse antes de que la entidad se persista (inserte) en la base de datos por primera vez.
    Se utiliza @PrePersist para asignar el valor actual de la fecha y hora al campo fechaCreacion justo antes de que el objeto se inserte en la base de datos.*/
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
    
    //GETTERS

    public int getIdSesion() {
        return idSesion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public EjerciciosPracticados getEjercicio1() {
        return ejercicio1;
    }

    public EjerciciosPracticados getEjercicio2() {
        return ejercicio2;
    }

    public EjerciciosPracticados getEjercicio3() {
        return ejercicio3;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    
    
    //SETTERS

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEjercicio1(EjerciciosPracticados ejercicio1) {
        this.ejercicio1 = ejercicio1;
    }

    public void setEjercicio2(EjerciciosPracticados ejercicio2) {
        this.ejercicio2 = ejercicio2;
    }

    public void setEjercicio3(EjerciciosPracticados ejercicio3) {
        this.ejercicio3 = ejercicio3;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

   
    
    
}
