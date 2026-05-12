package com.tareas.tareas.controller;

import com.tareas.tareas.entity.Tarea;
import com.tareas.tareas.service.TareaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Tarea buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea crear(@RequestBody Tarea tarea) {

        return service.crear(tarea);
    }

    @PutMapping("/{id}/completar")
    public Tarea completar(@PathVariable Long id) {

        return service.completar(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String manejarNoEncontrado(EntityNotFoundException ex) {

        return ex.getMessage();
    }
}