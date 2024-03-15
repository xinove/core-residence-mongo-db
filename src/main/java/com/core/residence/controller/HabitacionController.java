package com.core.residence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.core.residence.dto.RoomDto;
import com.core.residence.model.Room;
import com.core.residence.model.RoomRequest;
import com.core.residence.repositories.HabitacionRepository;
import com.google.gson.Gson;

// Controlador REST para manejar las solicitudes HTTP relacionadas con las habitaciones
@RestController
@RequestMapping("/habitacion")
@Slf4j
public class HabitacionController {


	@Autowired
	private HabitacionRepository habitacionRepository;

    @PostMapping("/habitacion")
    public ResponseEntity<String> crearHabitacion(@RequestBody RoomDto habitacion) {
    	//Con SErvice debemos crear la habitación
    	//habitacionService
    	Room miRoom = new Room();
    	log.info("Llegmos00");
    	System.out.println("Hola?");
        //habitacionRepository.saveRoom(habitacion);
        return ResponseEntity.ok().build();
    }
    

}