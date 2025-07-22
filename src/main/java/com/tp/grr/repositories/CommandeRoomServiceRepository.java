package com.tp.grr.repositories;



import com.tp.grr.models.CommandeRoomService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommandeRoomServiceRepository extends MongoRepository<CommandeRoomService, String> {
    List<CommandeRoomService> findByIdClient(String idClient);
}
