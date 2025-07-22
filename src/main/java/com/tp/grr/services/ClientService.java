package com.tp.grr.services;

import org.springframework.stereotype.Service;

import com.tp.grr.models.Client;


//import java.util.List;

@Service
public class ClientService {

    // Exemple : méthode fictive pour réserver une chambre
    public String reserverChambre(Client client, String chambreId, String dateDebut, String dateFin) {
        // Logique fictive pour enregistrer une réservation
        // À remplacer avec vraie logique + enregistrement BDD
        return "Réservation effectuée pour le client " + client.getNom() + " du " + dateDebut + " au " + dateFin;
    }

    public String annulerReservation(String reservationId) {
        // Logique fictive
        return "Réservation " + reservationId + " annulée avec succès";
    }

    public String commanderRoomService(Client client, String typeService) {
        // Logique fictive
        return "Room service '" + typeService + "' commandé pour " + client.getNom();
    }

    public String modifierRoomService(String serviceId, String nouveauType) {
        // Logique fictive
        return "Room service modifié en : " + nouveauType;
    }

    public String annulerRoomService(String serviceId) {
        // Logique fictive
        return "Room service " + serviceId + " annulé";
    }
}
