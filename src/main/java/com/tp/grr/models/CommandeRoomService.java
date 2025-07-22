package com.tp.grr.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "commanderoomservices")
public class CommandeRoomService {

    @Id
    private String idCommande;
    private LocalDateTime dateCommande;
    private String statut; // ex: "en cours", "terminée", "annulée"
    private String idClient;

    // Liste des services commandés — on stocke les IDs des RoomService commandés
    private List<String> idRoomServices;

    // Prix total calculé de la commande
    private double prixTotal;

    public CommandeRoomService() {}

    public CommandeRoomService(LocalDateTime dateCommande, String statut, String idClient, List<String> idRoomServices) {
        this.dateCommande = dateCommande;
        this.statut = statut;
        this.idClient = idClient;
        this.idRoomServices = idRoomServices;
    }

    // Getters & Setters
    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public List<String> getIdRoomServices() {
        return idRoomServices;
    }

    public void setIdRoomServices(List<String> idRoomServices) {
        this.idRoomServices = idRoomServices;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     * Calcule le prix total de la commande en sommant les prix de chaque RoomService.
     * Nécessite que le service associé soit injecté pour récupérer les prix.
     */
    public double calculerPrix(List<RoomService> servicesCommandes) {
        double total = 0;
        for (RoomService rs : servicesCommandes) {
            total += rs.getPrix();
        }
        this.prixTotal = total;
        return total;
    }
}
