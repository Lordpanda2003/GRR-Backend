package com.tp.grr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chambres")
public class Chambre {

    @Id
    private String idChambre;
    private String numeroChambre;
    private String statut; // exemple: "Libre", "Occupée", "Réservée"
    private String type;   // exemple: "Standard", "Deluxe", "Suite"
    private double prix;
    private String description;
    private String imageUrl; // Lien de l'image

    public Chambre() {}

    public Chambre(String numeroChambre, String statut, String type, double prix, String description, String imageUrl) {
        this.numeroChambre = numeroChambre;
        this.statut = statut;
        this.type = type;
        this.prix = prix;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public boolean estDisponible() {
        return this.statut != null && this.statut.equalsIgnoreCase("Libre");
    }

    // Getters et setters
    public String getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(String idChambre) {
        this.idChambre = idChambre;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
