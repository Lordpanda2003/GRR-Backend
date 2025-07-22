package com.tp.grr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "clients")
public class Client {

    @Id
    private String idClient;
    private String nom;
    private String prenom;
    private String tel;
    private String email;

    private List<String> reservationsIds;
    private List<String> roomServicesIds;

    public Client() {}

    public Client(String nom, String prenom, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getReservationsIds() {
        return reservationsIds;
    }

    public void setReservationsIds(List<String> reservationsIds) {
        this.reservationsIds = reservationsIds;
    }

    public List<String> getRoomServicesIds() {
        return roomServicesIds;
    }

    public void setRoomServicesIds(List<String> roomServicesIds) {
        this.roomServicesIds = roomServicesIds;
    }
}
