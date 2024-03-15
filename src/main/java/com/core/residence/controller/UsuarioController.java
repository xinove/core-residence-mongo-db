package com.core.residence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.residence.dto.UserDto;
import com.core.residence.model.User;
import com.core.residence.repositories.UsuarioRepository;
import com.core.residence.service.UserService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@RestController
//@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> obtenerTodosLosUsuarios() {
        return userService.findAll();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        // Aquí puedes realizar la lógica para obtener un usuario por su ID
    	System.out.println("HOLAAA X DIOS");
        //UserDto userDto = userService.getUserById(id);

        // Verificar si se encontró el usuario
//        if (userDto != null) {
        	if (true) {
            // Devolver el usuario y el estado HTTP 200 OK si se encontró
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            // Devolver un estado HTTP 404 Not Found si el usuario no se encontró
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
    	System.out.println("hola q pasa");
    	log.info("Hola??");    	
        User newUser = userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
    	User delUser = userService.deleteUser(userId);
    	
        // Devuelve una respuesta con el estado HTTP 200 OK si la eliminación fue exitosa
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
}
    