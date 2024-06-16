/*AUTORA:ANTONELLA ALARES*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitness;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anto_
 */

@RestController
@RequestMapping("/alimentos")
public class AlimentosAgregadosController {
    
     @Autowired
    private AlimentosAgregadosRepository alimentosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/guardar")
    public String guardarAlimentos(@RequestBody List<AlimentosAgregados> alimentos, @RequestParam int telefono, @RequestParam String nombrePlanning) {
        // Buscar el idUsuario basado en el número de teléfono
        Optional<Usuarios> usuarioOptional = usuariosRepository.findByTelefono(telefono);
        if (!usuarioOptional.isPresent()) {
            return "Error: No se encontró ningún usuario con el número de teléfono proporcionado.";
        }

        Usuarios usuario = usuarioOptional.get();
        int idUsuario = usuario.getIdUsuario();

        // Asignar el id de usuario y nombre de planning a cada alimento
        alimentos.forEach(alimento -> {
            alimento.setIdUsuario(idUsuario);
            alimento.setNombrePlanning(nombrePlanning);
        });

        // Guardar los alimentos en la base de datos
        alimentosRepository.saveAll(alimentos);

        return "Alimentos guardados exitosamente.";
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<AlimentosAgregados> getAlimentoById(@PathVariable int id) { // ResponseEntity es una clase de Spring que representa toda la respuesta HTTP: el estado, los encabezados y el cuerpo
        
        // Busca un usuario por su ID
        Optional<AlimentosAgregados> alimento = alimentosRepository.findById(id);
        // Si se encuentra el pedido, devuelve una respuesta HTTP 200 (OK) con el usuario encontrado
        if (alimento.isPresent()) { //isPresent(): Devuelve true si el Optional contiene un valor, o false si está vacío.
            return ResponseEntity.ok(alimento.get());  
         // El método ok es un método estático de ResponseEntity que crea una instancia de ResponseEntity con un estado HTTP 200 (OK) y el cuerpo de la respuesta configurado con el valor proporcionado
        // Si el Optional contiene un valor (es decir, no está vacío), get() devolverá ese valor
        } else {
            // Si no se encuentra el usuario, devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/por-telefono")
    public ResponseEntity<List<AlimentosAgregados>> obtenerFoodPlanningsPorTelefono(@RequestParam int telefono) {
        List<AlimentosAgregados> foodPlannings = alimentosRepository.obtenerFoodPlanningsPorTelefono(telefono);
        if (foodPlannings.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foodPlannings);
        }
    }
}
