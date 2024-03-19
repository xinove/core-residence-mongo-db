package com.core.residence.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.core.residence.dto.RoomDto;
import com.core.residence.dto.UserDto;
import com.core.residence.model.Room;
import com.core.residence.model.User;
import com.core.residence.repositories.HabitacionRepository;

import lombok.extern.slf4j.Slf4j;

import org.bson.types.ObjectId;

@Slf4j
@Service
public class RoomService {

    @Autowired
    @Qualifier("HabitacionRepository")
    private HabitacionRepository roomRepository;


	public List<Room> findAll() {
        return roomRepository.findAll();
	}

	public Room deleteRoom(ObjectId roomId) {
		 // Busca el usuario por su ID en la base de datos
        Optional<Room> userOptional = roomRepository.findById(roomId);
        
        if (userOptional.isPresent()) {
            // Si el usuario existe, elimínalo de la base de datos
            roomRepository.delete(userOptional.get());
            return userOptional.get();
        } else {
            // Si el usuario no existe, devuelve null o lanza una excepción, dependiendo de tus requisitos
            return null;
        }
	}
	 public Room createRoom(RoomDto roomDto) {
	        // Mapear los datos del DTO a una entidad de usuario
	        Room miroom = new Room ();
	        miroom.saveRoom(roomDto);
	        log.info(miroom.toString());
	        // Guardar la nueva habitación en la base de datos
	        return roomRepository.save(miroom);
	    }


	public Room save(Room miRoom) {
        Room roomOptional = roomRepository.save(miRoom);
        return roomOptional;		
	}
	
	public Room getRoomById(String id) {
		// TODO Auto-generated method stub
		 // Busca la habitacion por su ID en la base de datos
        ObjectId objectId = new ObjectId(id);

        Optional<Room> roomOptional = roomRepository.findById(objectId);
        log.info("IsPresent() " + roomRepository.findById(objectId) );
        if (roomOptional.isPresent()) {
            return roomOptional.get();
        } else {
            // Si el usuario no existe, devuelve null o lanza una excepción, dependiendo de tus requisitos
            return null;
        }
	}
}
