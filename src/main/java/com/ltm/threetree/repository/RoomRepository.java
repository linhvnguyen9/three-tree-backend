package com.ltm.threetree.repository;


import com.ltm.threetree.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findRoomByServerPort(int port);

    List<Room> findAll();

    Room save(Room room);

    void deleteRoomByServerPort(int port);
}
