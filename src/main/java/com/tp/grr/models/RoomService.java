package com.tp.grr.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roomservices")
public class RoomService {
    @Id
    private String idService;
    private String nom;
    private String description;
    private double prix;
    private String type; // gastronomique, massage, visite, etc.

    // optionnel : idReservation, si tu veux lier à une réservation
    private String idReservation;

    // Constructors
    public RoomService() {}

    public RoomService(String nom, String description, double prix, String type, String idReservation) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.type = type;
        this.idReservation = idReservation;
    }

    // Getters and Setters
    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }
}
