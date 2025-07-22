package com.tp.grr.controllers;



import com.tp.grr.models.Employe;
import com.tp.grr.services.EmployeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins = "*")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping
    public List<Employe> getAll() {
        return employeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable String id) {
        return employeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employe create(@RequestBody Employe employe) {
        return employeService.save(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable String id, @RequestBody Employe employe) {
        Employe updated = employeService.update(id, employe);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return employeService.getById(id).map(e -> {
            employeService.delete(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // Endpoints pour gérer les actions métier

    @PutMapping("/{idEmploye}/accepter-commande/{idCommande}")
    public ResponseEntity<Void> accepterCommande(@PathVariable String idEmploye, @PathVariable String idCommande) {
        boolean success = employeService.accepterCommande(idCommande);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{idEmploye}/refuser-commande/{idCommande}")
    public ResponseEntity<Void> refuserCommande(@PathVariable String idEmploye, @PathVariable String idCommande) {
        boolean success = employeService.refuserCommande(idCommande);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{idEmploye}/accepter-reservation/{idReservation}")
    public ResponseEntity<Void> accepterReservation(@PathVariable String idEmploye, @PathVariable String idReservation) {
        boolean success = employeService.accepterReservation(idReservation);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{idEmploye}/annuler-reservation/{idReservation}")
    public ResponseEntity<Void> annulerReservation(@PathVariable String idEmploye, @PathVariable String idReservation) {
        boolean success = employeService.annulerReservation(idReservation);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
