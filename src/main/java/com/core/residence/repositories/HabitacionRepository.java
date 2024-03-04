package com.core.residence.repositories;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.core.residence.model.Room;
import com.core.residence.model.User;

public interface HabitacionRepository extends MongoRepository<Room, String> {

	Room saveRoom(Room hab);

	Optional<Room> findById(Long roomId);

}
