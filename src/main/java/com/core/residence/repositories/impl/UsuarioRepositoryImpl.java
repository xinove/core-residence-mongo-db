package com.core.residence.repositories.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.core.residence.model.User;
import com.core.residence.repositories.UsuarioRepository;
import com.core.residence.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UsuarioRepositoryImpl implements UsuarioRepository {

	private final MongoOperations mongoOperations;

	 
    public UsuarioRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

	@Override
	public User save(User user) {
		mongoOperations.save(user);
		return user;
	}
	@Override
	public <S extends User> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	 public Optional<User> findById(ObjectId id) {
        Query query = new Query(Criteria.where("_id").is(id));
        User user = mongoOperations.findOne(query, User.class, "usuarios");
        return Optional.ofNullable(user);
    }

	@Override
	public boolean existsById(ObjectId id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(ObjectId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllById(Iterable<ObjectId> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllById(Iterable<? extends ObjectId> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

    // Implementación personalizada de métodos del repositorio si es necesario
}