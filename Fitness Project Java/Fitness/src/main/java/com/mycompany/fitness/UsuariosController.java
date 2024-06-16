/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

// Importa las anotaciones y clases necesarias de Spring Framework

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


/**
 *
 * @author anto_
 */

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController
// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/usuarios")
public class UsuariosController {
    
    
     // Inyecta una instancia de UsuariosRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private UsuariosRepository usuarioRepository;
   
    
    
    
    // Maneja las solicitudes GET a /usuarios para obtener una lista de todas los usuarios
    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        // Llama al método findAll() del repositorio para obtener todas los usuarios
        return usuarioRepository.findAll();
    }

    // Maneja las solicitudes GET a /usuarios/{id} para obtener un usuario específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable int id) { // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca un usuario por su ID
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        // Si se encuentra el pedido, devuelve una respuesta HTTP 200 (OK) con el usuario encontrado
        if (usuario.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            return ResponseEntity.ok(usuario.get());  
         // El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra el usuario, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    // Maneja las solicitudes GET a /usuarios/telefono para obtener un usuario específico por su telefono
    @GetMapping("/telefono")
    public ResponseEntity<Optional<Usuarios>> getUsuarioByTelefono(@RequestParam int telefono) {
        Optional<Usuarios> usuario = usuarioRepository.findByTelefono(telefono);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /*Maneja las solicitudes GET a /usuarios/{telefono}/conteo para obtener el número de rutinas 
y el número de sesiones de entrenamientos que tiene un usuario con un número de telefono determinado*/
    
     @GetMapping("/usuario/conteo")
public String getConteoByTelefono(@RequestParam int telefono) {
    Optional<Usuarios> optionalUsuario = usuarioRepository.findByTelefono(telefono);
    if (optionalUsuario.isPresent()) {
        Usuarios usuario = optionalUsuario.get();
        int rutinasCount = usuarioRepository.countRutinasByUsuarioId(usuario.getIdUsuario());
        int entrenamientosCount = usuarioRepository.countEntrenamientosByUsuarioId(usuario.getIdUsuario());
        int foodPlanningsCount = usuarioRepository.countFoodPlanningsByUsuarioId(usuario.getIdUsuario());
        return String.format("{\"rutinas\": %d, \"entrenamientos\": %d, \"foodPlannings\": %d}", rutinasCount, entrenamientosCount, foodPlanningsCount);
    } else {
        return "{\"error\":\"Usuario no encontrado\"}";
    }
}

    
    

    // Maneja las solicitudes POST a /usuarios para crear un nuevo usuario
    @PostMapping
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
         // Guarda el nuevo usuario en la base de datos y lo devuelve en la respuesta
        return usuarioRepository.save(usuario);
    }

    // Maneja las solicitudes PUT a /usuarios/{id} para actualizar un usuario ya existente
    @PutMapping("actualizar-nombre-correo/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable int id, @RequestBody Usuarios usuarioDetails) {
        // Busca un usuario por su ID
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        // Si se encuentra el usuario, actualiza sus detalles y lo guarda
        if (usuario.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            Usuarios usuarioToUpdate = usuario.get();
            // Actualiza el nombre y el email del usuario con los detalles proporcionados en la solicitud
            usuarioToUpdate.setNombre(usuarioDetails.getNombre());
            usuarioToUpdate.setEmail(usuarioDetails.getEmail());
            // Guarda el usuario actualizado y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(usuarioRepository.save(usuarioToUpdate));
        } else {
            // Si no se encuentra el usuario, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    

    // Maneja las solicitudes DELETE a /usuarios/{id} para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
         // Maneja las solicitudes DELETE a /usuarios/{id} para eliminar un usuario por su ID
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        // Si se encuentra el usuario, la elimina de la base de datos
        if (usuario.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
           usuarioRepository.delete(usuario.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra el usuario, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    
}
