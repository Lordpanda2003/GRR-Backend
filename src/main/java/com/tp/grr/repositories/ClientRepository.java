package com.tp.grr.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tp.grr.models.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    // Tu peux ajouter des méthodes de recherche personnalisées ici si besoin, exemple :
    Client findByEmail(String email);
}
