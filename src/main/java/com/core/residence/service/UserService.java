package com.core.residence.service;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.core.residence.controller.UsuarioController;
import com.core.residence.dto.UserDto;
import com.core.residence.model.User;
import com.core.residence.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository userRepository;

    public User createUser(UserDto userDto) {
        // Mapear los datos del DTO a una entidad de usuario
        User user = new User();
        user.setName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        log.info(user.toString());
        // Guardar el nuevo usuario en la base de datos
        return userRepository.save(user);
    }

	public List<User> findAll() {
        return userRepository.findAll();
	}

	public User deleteUser(String userId) {
		 // Busca el usuario por su ID en la base de datos
		ObjectId objectId = new ObjectId(userId); //duda
        Optional<User> userOptional = userRepository.findById(objectId);
        
        if (userOptional.isPresent()) {
            // Si el usuario existe, elimínalo de la base de datos
            userRepository.delete(userOptional.get());
            return userOptional.get();
        } else {
            // Si el usuario no existe, devuelve null o lanza una excepción, dependiendo de tus requisitos
            return null;
        }
	}

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		 // Busca el usuario por su ID en la base de datos
        ObjectId objectId = new ObjectId(id);

        Optional<User> userOptional = userRepository.findById(objectId);
        log.info("IsPresent() " + userRepository.findById(objectId) );
        if (userOptional.isPresent()) {
            // Si el usuario existe, elimínalo de la base de datos
            return userOptional.get();
        } else {
            // Si el usuario no existe, devuelve null o lanza una excepción, dependiendo de tus requisitos
            return null;
        }
	}
}
