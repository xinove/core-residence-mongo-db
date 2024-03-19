package com.core.residence.repositories;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.core.residence.model.User;
import org.bson.types.ObjectId;

public interface UsuarioRepository extends MongoRepository<User, ObjectId> {

	User saveUser(User user);

	Optional<User> findById(Long userId);

}
