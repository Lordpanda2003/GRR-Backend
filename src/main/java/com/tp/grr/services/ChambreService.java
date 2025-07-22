package com.tp.grr.services;



import com.tp.grr.models.Chambre;
import com.tp.grr.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> getChambreById(String id) {
        return chambreRepository.findById(id);
    }

    public Chambre createChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Optional<Chambre> updateChambre(String id, Chambre updated) {
        return chambreRepository.findById(id).map(chambre -> {
            chambre.setNumeroChambre(updated.getNumeroChambre());
            chambre.setStatut(updated.getStatut());
            chambre.setType(updated.getType());
            chambre.setPrix(updated.getPrix());
            chambre.setDescription(updated.getDescription());
            chambre.setImageUrl(updated.getImageUrl());
            return chambreRepository.save(chambre);
        });
    }

    public boolean deleteChambre(String id) {
        return chambreRepository.findById(id).map(chambre -> {
            chambreRepository.delete(chambre);
            return true;
        }).orElse(false);
    }
}
