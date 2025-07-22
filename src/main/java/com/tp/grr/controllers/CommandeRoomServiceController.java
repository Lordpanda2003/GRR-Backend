package com.tp.grr.controllers;



import com.tp.grr.models.CommandeRoomService;
import com.tp.grr.services.CommandeRoomServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes-roomservices")
public class CommandeRoomServiceController {

    @Autowired
    private CommandeRoomServiceService service;

    @GetMapping
    public List<CommandeRoomService> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeRoomService> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/client/{idClient}")
    public List<CommandeRoomService> getByClient(@PathVariable String idClient) {
        return service.getByClientId(idClient);
    }

    @PostMapping
    public CommandeRoomService create(@RequestBody CommandeRoomService commande) {
        return service.save(commande);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeRoomService> update(@PathVariable String id, @RequestBody CommandeRoomService commande) {
        CommandeRoomService updated = service.update(id, commande);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return service.getById(id).map(c -> {
            service.delete(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
