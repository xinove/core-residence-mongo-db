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

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> obtenerTodosLosUsuarios() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
    	
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
    