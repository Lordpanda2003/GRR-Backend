package com.tp.grr.services;



import com.tp.grr.models.RoomService;
import com.tp.grr.repositories.RoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceService {

    @Autowired
    private RoomServiceRepository repository;

    public List<RoomService> getAll() {
        return repository.findAll();
    }

    public Optional<RoomService> getById(String id) {
        return repository.findById(id);
    }

    public RoomService save(RoomService roomService) {
        return repository.save(roomService);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<RoomService> getByType(String type) {
        return repository.findByType(type);
    }

    public List<RoomService> getByReservation(String idReservation) {
        return repository.findByIdReservation(idReservation);
    }
}
