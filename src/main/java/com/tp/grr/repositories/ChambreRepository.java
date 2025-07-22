package com.tp.grr.repositories;

import com.tp.grr.models.Chambre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChambreRepository extends MongoRepository<Chambre, String> {
    // Tu peux ajouter des méthodes personnalisées ici si besoin
}
