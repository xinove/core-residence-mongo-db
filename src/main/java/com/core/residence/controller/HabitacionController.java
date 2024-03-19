package com.core.residence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.core.residence.dto.RoomDto;
import com.core.residence.dto.UserDto;
import com.core.residence.model.Room;
import com.core.residence.model.RoomRequest;
import com.core.residence.model.User;
import com.core.residence.repositories.HabitacionRepository;
import com.core.residence.service.RoomService;
import com.core.residence.service.UserService;
import com.google.gson.Gson;

// Controlador REST para manejar las solicitudes HTTP relacionadas con las habitaciones
@RestController
@Slf4j
public class HabitacionController {

	@Autowired
    private RoomService roomService;
	
	 @GetMapping("/habitacion")
	    public ResponseEntity<RoomDto> getAllHabitaciones() {
	        // Aquí puedes realizar la lógica para obtener un usuario por su ID
	    	log.info(" Get RoomrAll " );
	    	List<Room> lstroom = roomService.findAll();
	    	
	    	if (lstroom != null || !lstroom.isEmpty()) {
	        	log.info("No esta vacio!!");
	            // Devolver el usuario y el estado HTTP 200 OK si se encontró
	            return new ResponseEntity<>( HttpStatus.OK);
	        } else {
	            // Devolver un estado HTTP 404 Not Found si el usuario no se encontró
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	  @GetMapping("/habitacion/id={id}")
	    public ResponseEntity<Room> getRoomById(@PathVariable String id) {
	        // Aquí puedes realizar la lógica para obtener un usuario por su ID
	    	log.info(" Get RoombyId " + id);
	    	Room hab = roomService.getRoomById(id);

	        // Verificar si se encontró la habitacion
	        if (hab != null) {
	        	log.info(hab.toString());
	        	
	            // Devolver la habitacion y el estado HTTP 200 OK si se encontró
	            return ResponseEntity.ok(hab);
	        } else {
	            // Devolver un estado HTTP 404 Not Found si el usuario no se encontró
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
    @PostMapping("/habitacion")
    public ResponseEntity<String> crearHabitacion(@RequestBody RoomDto habitacion) {
    	//Con SErvice debemos crear la habitación
    	log.info(" Post Rooml " );
    	Room miRoom = new Room();
    	miRoom.saveRoom(habitacion);
    	miRoom = roomService.save(miRoom);
    	log.info(" Get RoomrAll " );
    	if (miRoom == null)
    		return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }
    

}