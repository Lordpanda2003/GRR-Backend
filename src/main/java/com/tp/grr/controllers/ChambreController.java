package com.tp.grr.controllers;


import com.tp.grr.models.Chambre;
import com.tp.grr.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
@CrossOrigin(origins = "*")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable String id) {
        return chambreService.getChambreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.createChambre(chambre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable String id, @RequestBody Chambre chambre) {
        return chambreService.updateChambre(id, chambre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable String id) {
        boolean deleted = chambreService.deleteChambre(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
