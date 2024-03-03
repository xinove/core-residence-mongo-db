package com.core.residence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador REST para manejar las solicitudes HTTP relacionadas con las habitaciones
@RestController
@RequestMapping("/habitacion")
public class HabitacionController {
/*
    @Autowired
    private HabitacionRepository habitacionRepository;

    @PostMapping
    public ResponseEntity<?> crearHabitacion(@RequestBody Room habitacion) {
        habitacionRepository.save(habitacion);
        return ResponseEntity.ok().build();
    }
    */
}