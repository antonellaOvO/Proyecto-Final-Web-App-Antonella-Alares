/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 *
 * @author anto_
 */

@Service
public class RutinasService {
    
     @Autowired
    private UsuariosRepository usuarioRepository;

    @Autowired
    private RutinasRepository rutinaRepository;

    public Rutinas createRutina(int telefono, Rutinas rutina) {
        Usuarios usuario = usuarioRepository.findByTelefono(telefono).orElse(null);
        if (usuario != null) {
            rutina.setUsuario(usuario);
            return rutinaRepository.save(rutina);
        } else {
            throw new RuntimeException("Usuario no encontrado con el teléfono: " + telefono);
        }
    }
    
    

    
    
}
