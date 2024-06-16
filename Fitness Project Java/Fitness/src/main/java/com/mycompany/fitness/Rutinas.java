/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.*;
import java.time.LocalDateTime;

/**
 *
 * @author anto_
 */

@Entity
public class Rutinas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rutina")
    private int idRutina;
    /*Define la columna id_usuario en la tabla Rutinas como la clave foránea que referencia a la tabla Usuarios. 
    El atributo name especifica el nombre de la columna en la base de datos, y nullable = false indica que esta columna no puede ser nula.*/
   
  
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) //
    private Usuarios usuario;
    @Column(name = "objetivo_rutina")
    private String objetivo;
    
    @Column(name = "ejercicio1")
    private int ejercicio1;
    @Column(name = "ejercicio2")
    private int ejercicio2;
    @Column(name = "fechaCreacion_rutina")
    private LocalDateTime fechaCreacion;
    
    
    
    
    /*La anotación @PrePersist es una anotación de JPA (Java Persistence API) 
    utilizada para marcar un método en una entidad que debe ejecutarse antes de que la entidad se persista (inserte) en la base de datos por primera vez.
    Se utiliza @PrePersist para asignar el valor actual de la fecha y hora al campo fechaCreacion justo antes de que el objeto se inserte en la base de datos.*/
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
    
    //GETTERS

    public int getIdRutina() {
        return idRutina;
    }
    
    

    public Usuarios getUsuario() {
        return usuario;
    }

    public String getObjetivo() {
        return objetivo;
    }
    
    

    public int getEjercicio1() {
        return ejercicio1;
    }

    public int getEjercicio2() {
        return ejercicio2;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    
    
    //SETTERS

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    

   public void setEjercicio1(int ejercicio1) {
        this.ejercicio1 = ejercicio1;
    }

    public void setEjercicio2(int ejercicio2) {
        this.ejercicio2 = ejercicio2;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    

    
    
    
}
