package com.core.residence.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.core.residence.model.User;

public interface UsuarioRepository extends MongoRepository<User, String> {
}
