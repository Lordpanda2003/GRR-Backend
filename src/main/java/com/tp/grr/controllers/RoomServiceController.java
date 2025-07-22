package com.tp.grr.controllers;



import com.tp.grr.models.RoomService;
import com.tp.grr.services.RoomServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomservices")
public class RoomServiceController {

    @Autowired
    private RoomServiceService service;

    @GetMapping
    public List<RoomService> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomService> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public List<RoomService> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/reservation/{idReservation}")
    public List<RoomService> getByReservation(@PathVariable String idReservation) {
        return service.getByReservation(idReservation);
    }

    @PostMapping
    public RoomService create(@RequestBody RoomService roomService) {
        return service.save(roomService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomService> update(@PathVariable String id, @RequestBody RoomService roomService) {
        return service.getById(id).map(existing -> {
            roomService.setIdService(id);
            return ResponseEntity.ok(service.save(roomService));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return service.getById(id).map(roomService -> {
            service.delete(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

