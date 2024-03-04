package com.core.residence.repositories;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.core.residence.model.User;

public interface UsuarioRepository extends MongoRepository<User, String> {

	User saveUser(User user);

	Optional<User> findById(Long userId);

}
