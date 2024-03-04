package com.core.residence.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.residence.dto.UserDto;
import com.core.residence.model.User;
import com.core.residence.repositories.UsuarioRepository;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository userRepository;

    public User createUser(UserDto userDto) {
        // Mapear los datos del DTO a una entidad de usuario
        User user = new User();
        user.setName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        // Guardar el nuevo usuario en la base de datos
        return userRepository.save(user);
    }

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
