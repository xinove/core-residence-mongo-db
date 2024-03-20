package com.core.residence.repositories;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.core.residence.model.HistoricRoom;
import com.core.residence.model.Room;
import org.bson.types.ObjectId;

@Repository("HabitacionRepository")
public interface HabitacionRepository extends MongoRepository<Room, ObjectId> {

	void saveHistoric( HistoricRoom miroom);
	Room findByOrigenAndName (Room miroom);
}
