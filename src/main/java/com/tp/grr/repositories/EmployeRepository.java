package com.tp.grr.repositories;



import com.tp.grr.models.Employe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeRepository extends MongoRepository<Employe, String> {
    // Tu peux ajouter des méthodes personnalisées si besoin
}
