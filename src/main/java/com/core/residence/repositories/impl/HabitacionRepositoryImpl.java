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

import com.core.residence.model.HistoricRoom;
import com.core.residence.model.Room;
import com.core.residence.model.User;
import com.core.residence.repositories.HabitacionRepository;
import com.core.residence.repositories.UsuarioRepository;
import com.core.residence.service.RoomService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class HabitacionRepositoryImpl implements HabitacionRepository {

	private final MongoOperations mongoOperations;
	private final String coleccionMongo = "habitaciones";
	@Autowired
    public HabitacionRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

	@Override
	public Room save(Room hab) {
		mongoOperations.save(hab);
		return hab;
	}

	@Override
	public <S extends Room> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Room> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Room> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Room> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Room> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> findAllById(Iterable<ObjectId> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(ObjectId id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(ObjectId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Room entity) {
		Query query = new Query(Criteria.where("_id").is(entity.getId()));
	    mongoOperations.remove(query, coleccionMongo);
	}
	public void saveHistoric(HistoricRoom hr) {
	       mongoOperations.save( hr, "historico_habitaciones");
	}


	@Override
	public void deleteAllById(Iterable<? extends ObjectId> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Room> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Room> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Room> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Room> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Room> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Room> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Room> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	 public Optional<Room> findById(ObjectId id) {
       Query query = new Query(Criteria.where("_id").is(id));
       Room hab = mongoOperations.findOne(query, Room.class, "habitaciones");
       return Optional.ofNullable(hab);
   }
	@Override
	public <S extends Room, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room findByOrigenAndName(Room miroom) {
		 // Busca la habitacion por su ID en la base de datos
		Query query = new Query();
		//Buscamos la habitacion: 
			
		query.addCriteria(Criteria.where("origen").is(miroom.getOrigen()).and("name").is(miroom.getName()));
		Room aux =  mongoOperations.findOne(query, Room.class);
		if (aux !=null)
			log.info("Existe: " + aux.getName());
		else
			log.info("Es NULL!!!");
   		return aux;
	}

}