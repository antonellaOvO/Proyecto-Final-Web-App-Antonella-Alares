/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import javax.persistence.*;

/**
 *
 * @author anto_
 */

@Entity
public class Ejercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private int id;
    
    @Column(name = "objetivo")
    private String objetivo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "imagen")
    private String imagen; // Ruta a la imagen en la carpeta "images"
    
    @Column(name = "video")
    private String video;  // Enlace a YouTube

    public Ejercicios() {
    }

    
    
    
    // GETTERS

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getImagen() {
        return imagen;
    }

    public String getVideo() {
        return video;
    }
    
    
    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    
    
    
}
