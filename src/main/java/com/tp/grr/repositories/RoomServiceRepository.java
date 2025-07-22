package com.tp.grr.repositories;


import com.tp.grr.models.RoomService;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RoomServiceRepository extends MongoRepository<RoomService, String> {
    List<RoomService> findByType(String type);
    List<RoomService> findByIdReservation(String idReservation);
}
