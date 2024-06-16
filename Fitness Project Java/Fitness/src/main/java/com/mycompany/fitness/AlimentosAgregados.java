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
public class AlimentosAgregados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alimento")
    private int idAlimento;
    
    @Column(name = "nombre_planning")
    private String nombrePlanning;
    
    @Column(name = "id_usuario")
    private int idUsuario;
   
    @Column(name = "nombre_alimento")
    private String nombreAlimento;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "calorias")
    private double calorias;
    
    @Column(name = "proteinas")
    private double proteinas;
    
    @Column(name = "datos_adicionales")
    private String datosAdicionales;
    

    public AlimentosAgregados() {
    }
    
    
    //GETTERS

    public int getIdAlimento() {
        return idAlimento;
    }

    public String getNombrePlanning() {
        return nombrePlanning;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public String getDatosAdicionales() {
        return datosAdicionales;
    }

   

   
    
    
    
    
    //SETTERS

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public void setNombrePlanning(String nombrePlanning) {
        this.nombrePlanning = nombrePlanning;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public void setDatosAdicionales(String datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

    
   
    
    
    

    
}
