package com.tp.grr.services;


import com.tp.grr.models.Reservation;
import com.tp.grr.models.Chambre;
import com.tp.grr.repositories.ReservationRepository;
import com.tp.grr.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(String id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        Optional<Chambre> chambre = chambreRepository.findById(reservation.getIdChambre());
        if (chambre.isPresent()) {
            double prixParNuit = chambre.get().getPrix();
            reservation.calculePrix(prixParNuit);
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Chambre non trouvée");
        }
    }

    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
