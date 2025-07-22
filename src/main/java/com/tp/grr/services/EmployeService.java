package com.tp.grr.services;



import com.tp.grr.models.Employe;
import com.tp.grr.repositories.EmployeRepository;
import com.tp.grr.repositories.CommandeRoomServiceRepository;
import com.tp.grr.repositories.ReservationRepository;
import com.tp.grr.models.CommandeRoomService;
import com.tp.grr.models.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private CommandeRoomServiceRepository commandeRoomServiceRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    public Optional<Employe> getById(String id) {
        return employeRepository.findById(id);
    }

    public Employe save(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe update(String id, Employe updatedEmploye) {
        return employeRepository.findById(id).map(emp -> {
            emp.setNom(updatedEmploye.getNom());
            emp.setPrenom(updatedEmploye.getPrenom());
            emp.setRole(updatedEmploye.getRole());
            return employeRepository.save(emp);
        }).orElse(null);
    }

    public void delete(String id) {
        employeRepository.deleteById(id);
    }

    // Méthodes métier simulées (tu peux adapter avec ta logique métier)

    public boolean accepterCommande(String idCommande) {
        Optional<CommandeRoomService> commandeOpt = commandeRoomServiceRepository.findById(idCommande);
        if (commandeOpt.isPresent()) {
            CommandeRoomService commande = commandeOpt.get();
            commande.setStatut("Acceptée");
            commandeRoomServiceRepository.save(commande);
            return true;
        }
        return false;
    }

    public boolean refuserCommande(String idCommande) {
        Optional<CommandeRoomService> commandeOpt = commandeRoomServiceRepository.findById(idCommande);
        if (commandeOpt.isPresent()) {
            CommandeRoomService commande = commandeOpt.get();
            commande.setStatut("Refusée");
            commandeRoomServiceRepository.save(commande);
            return true;
        }
        return false;
    }

    public boolean accepterReservation(String idReservation) {
        Optional<Reservation> resOpt = reservationRepository.findById(idReservation);
        if (resOpt.isPresent()) {
            Reservation reservation = resOpt.get();
            reservation.setStatut("Acceptée");
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }

    public boolean annulerReservation(String idReservation) {
        Optional<Reservation> resOpt = reservationRepository.findById(idReservation);
        if (resOpt.isPresent()) {
            Reservation reservation = resOpt.get();
            reservation.setStatut("Annulée");
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
}
