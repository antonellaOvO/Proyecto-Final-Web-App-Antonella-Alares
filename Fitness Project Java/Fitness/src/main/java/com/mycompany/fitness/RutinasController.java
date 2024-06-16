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
@RequestMapping("/rutinas")
public class RutinasController {
    
    
     // Inyecta una instancia de RutinasRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private RutinasRepository rutinaRepository;
    
    @Autowired
    private RutinasService rutinaService;
   
    
    
    
    // Maneja las solicitudes GET a /rutinas para obtener una lista de todas las rutinas
    @GetMapping
    public List<Rutinas> getAllRutinas() {
        // Llama al método findAll() del repositorio para obtener todas las rutinas
        return rutinaRepository.findAll();
    }

    // Maneja las solicitudes GET a /rutinas/{id} para obtener una rutina específica por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Rutinas> getRutinaById(@PathVariable int id) { // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca una rutina por su ID
        Optional<Rutinas> rutina = rutinaRepository.findById(id);
        // Si se encuentra la rutina, devuelve una respuesta HTTP 200 (OK) con la rutina encontrada
        if (rutina.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            return ResponseEntity.ok(rutina.get());  
         // El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra la rutina, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/por-telefono")
public ResponseEntity<List<RutinasDTO>> obtenerRutinasUsuarioPorTelefono(@RequestParam int telefono) {
    try {
        List<RutinasDTO> rutinas = rutinaRepository.obtenerRutinasUsuarioPorTelefono(telefono);
        if (rutinas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rutinas);
        }
    } catch (Exception e) {
        // Agrega un registro para depurar el error
        System.err.println("Error al obtener rutinas por teléfono: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    

    // Maneja las solicitudes POST a /rutinas para crear una nueva rutina
    @PostMapping("/{telefono}")
    public ResponseEntity<Rutinas> createRutina(@PathVariable int telefono, @RequestBody Rutinas rutina) {
        Rutinas createdRutina = rutinaService.createRutina(telefono, rutina);
        return ResponseEntity.ok(createdRutina);
    }
    
    /*@PostMapping
    public Rutinas createRutina(@RequestBody Rutinas rutina) {
         // Guarda la neuva rutina en la base de datos y la devuelve en la respuesta
        return rutinaRepository.save(rutina);
    }*/

    // Maneja las solicitudes PUT a /rutinas/{id} para actualizar una rutina ya existente
    @PutMapping("actualizar-ejercicio1-ejercicio2/{id}")
    public ResponseEntity<Rutinas> updateRutina(@PathVariable int id, @RequestBody Rutinas rutinaDetails) {
        // Busca un usuario por su ID
        Optional<Rutinas> rutina = rutinaRepository.findById(id);
        // Si se encuentra la rutina, actualiza sus detalles y los guarda
        if (rutina.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            Rutinas rutinaToUpdate = rutina.get();
            // Actualiza el ejercicio1 y el ejercicio2 de la rutina con los detalles proporcionados en la solicitud
            rutinaToUpdate.setEjercicio1(rutinaDetails.getEjercicio1());
            rutinaToUpdate.setEjercicio2(rutinaDetails.getEjercicio2());
            // Guarda la rutina actualizada y devuelve una respuesta HTTP 200 (OK)
            return ResponseEntity.ok(rutinaRepository.save(rutinaToUpdate));
        } else {
            // Si no se encuentra la rutina, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    

    // Maneja las solicitudes DELETE a /usuarios/{id} para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRutina(@PathVariable int id) {
         // Maneja las solicitudes DELETE a /rutinas/{id} para eliminar una rutina por su ID
        Optional<Rutinas> rutina = rutinaRepository.findById(id);
        // Si se encuentra la rutina, la elimina de la base de datos
        if (rutina.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
           rutinaRepository.delete(rutina.get());
            // Devuelve una respuesta HTTP 200 (OK) sin contenido
            return ResponseEntity.ok().build();
            //build() se utiliza para construir una instancia de ResponseEntity sin cuerpo(body)
        } else {
            // Si no se encuentra la rutina, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
   /* @PostMapping
    public ResponseEntity<Personas> createPersona(@RequestBody Personas persona){
        Personas savedPersona = personaRepository.save(persona); //insert into Personas (apellido_persona, contrasena_persona, correo_persona, direccion_persona, DNI, fechaCreacion_persona, fechaNacimiento_persona, nombre_persona, telefono_persona, tipo, id_persona) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        
        if("Administrador".equals(persona.getTipo())){
            Administradores admin = new Administradores();
            admin.setId(savedPersona.getIdPersona());
            administradorRepository.save(admin); //insert into Administradores (id_administrador) values (?), aquí el ? = user 
        } else if("Usuario".equals(persona.getTipo())){
            Usuarios user = new Usuarios();
            user.setIdUsuario(savedPersona.getIdPersona());
            usuarioRepository.save(user); //insert into Usuarios (id_usuario) values (?), aquí ? = admin
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }*/
    
    
    
    
}
