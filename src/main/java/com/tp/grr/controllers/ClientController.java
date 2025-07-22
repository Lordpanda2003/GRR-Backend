package com.tp.grr.controllers;



import com.tp.grr.models.Client;
import com.tp.grr.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*") // Pour permettre l'accès depuis Angular
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // ✅ GET - Liste de tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // ✅ GET - Un client par ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        return clientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ POST - Ajouter un client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // ✅ PUT - Modifier un client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.setNom(updatedClient.getNom());
            client.setPrenom(updatedClient.getPrenom());
            client.setTel(updatedClient.getTel());
            client.setEmail(updatedClient.getEmail());
            return ResponseEntity.ok(clientRepository.save(client));
        }).orElse(ResponseEntity.notFound().build());
    }

    // ✅ DELETE - Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable String id) {
        return clientRepository.findById(id).map(client -> {
            clientRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

