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
import java.util.List;

/**
 *
 * @author anto_
 */
@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "fechaCreacion_usuario")
    private LocalDateTime fechaCreacion;
    @Column(name = "fechaBaja_usuario")
    private LocalDateTime fechaBaja;
    
    // Define la relación uno a muchos entre Usuarios y Rutinas. El atributo mappedBy indica que el lado inverso de la relación se encuentra en el campo usuario de la entidad Rutinas.
    @OneToMany(mappedBy = "usuario") 
    
    /*La anotación @PrePersist es una anotación de JPA (Java Persistence API) 
    utilizada para marcar un método en una entidad que debe ejecutarse antes de que la entidad se persista (inserte) en la base de datos por primera vez.
    Se utiliza @PrePersist para asignar el valor actual de la fecha y hora al campo fechaCreacion justo antes de que el objeto se inserte en la base de datos.*/
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaBaja = LocalDateTime.now();
    }

    
    public Usuarios (){
        
    }
    
    //GETTERS

    public int getIdUsuario() {
        return idUsuario;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }
    
    
    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }
    
    /*public List<Rutinas> getRutinas() {
        return rutinas;
    }*/

   
    //SETTERS

     public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
   /* public void setRutinas(List<Rutinas> rutinas) {
        this.rutinas = rutinas;
    }*/
    
    
    
    
    
     /*MÉTODOS DAO PARA ADAPTAR*/
   /* public String getCorreo(){
        return PersonaDAO.getPersonaCorreo(this.nombre, this.apellido);
    }
    
     public String getTipo(){
        return PersonaDAO.getTipo(this.id_persona);
    }
     
     
   
   public void setCorreo(String nuevoCorreo){
   PersonaDAO.updatePersonaCorreo(this.nombre,this.apellido, nuevoCorreo);
   }
   
   
   public static void CrearAsignarPersona(int id_persona, String nombre, String apellido, String tipo, String dni, String correo, int telefono, String contrasena, String fechaNacimiento, String direccion){
   PersonaDAO.insertPersona(id_persona, nombre, apellido, tipo, dni, correo, telefono, contrasena, fechaNacimiento, direccion);
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }
   
   public static void insertPersonaEnTablaCorrecta(int id_persona){
   PersonaDAO.insertPersonaEnTablaCorrecta(id_persona);
   }*/

    Usuarios orElse(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    

    
    
}
