package com.tp.grr.services;



import com.tp.grr.models.CommandeRoomService;
import com.tp.grr.models.RoomService;
import com.tp.grr.repositories.CommandeRoomServiceRepository;
import com.tp.grr.repositories.RoomServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeRoomServiceService {

    @Autowired
    private CommandeRoomServiceRepository commandeRepository;

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    public List<CommandeRoomService> getAll() {
        return commandeRepository.findAll();
    }

    public Optional<CommandeRoomService> getById(String id) {
        return commandeRepository.findById(id);
    }

    public List<CommandeRoomService> getByClientId(String idClient) {
        return commandeRepository.findByIdClient(idClient);
    }

    public CommandeRoomService save(CommandeRoomService commande) {
        // Récupérer les services commandés par leurs IDs
        List<RoomService> servicesCommandes = roomServiceRepository.findAllById(commande.getIdRoomServices());
        // Calculer le prix total
        commande.calculerPrix(servicesCommandes);
        // Sauvegarder la commande avec prixTotal mis à jour
        return commandeRepository.save(commande);
    }

    public void delete(String id) {
        commandeRepository.deleteById(id);
    }

    public CommandeRoomService update(String id, CommandeRoomService updatedCommande) {
        return commandeRepository.findById(id).map(existingCommande -> {
            existingCommande.setDateCommande(updatedCommande.getDateCommande());
            existingCommande.setStatut(updatedCommande.getStatut());
            existingCommande.setIdClient(updatedCommande.getIdClient());
            existingCommande.setIdRoomServices(updatedCommande.getIdRoomServices());

            // Recalculer le prix total avec les services mis à jour
            List<RoomService> servicesCommandes = roomServiceRepository.findAllById(updatedCommande.getIdRoomServices());
            existingCommande.calculerPrix(servicesCommandes);

            return commandeRepository.save(existingCommande);
        }).orElse(null);
    }
}
