package com.tp.grr.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Document(collection = "reservations")
public class Reservation {

    @Id
    private String idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut; // exemple : "Confirmée", "Annulée"
    private String idClient;
    private String idChambre;
    private double prixTotal;

    public Reservation() {}

    public Reservation(LocalDate dateDebut, LocalDate dateFin, String statut, String idClient, String idChambre) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.idClient = idClient;
        this.idChambre = idChambre;
    }

    public double calculePrix(double prixParNuit) {
        long jours = ChronoUnit.DAYS.between(dateDebut, dateFin);
        if (jours <= 0) jours = 1;
        this.prixTotal = prixParNuit * jours;
        return prixTotal;
    }

    // Getters et setters

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
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

    public String getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(String idChambre) {
        this.idChambre = idChambre;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
