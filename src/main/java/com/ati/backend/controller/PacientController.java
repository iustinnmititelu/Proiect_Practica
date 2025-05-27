package com.ati.backend.controller;

import com.ati.backend.model.Pacient;
import com.ati.backend.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacienti")
public class PacientController {

    @Autowired
    private PacientRepository pacientRepository;

    @GetMapping
    public List<Pacient> getAllPacienti() {
        return pacientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacient> getPacientById(@PathVariable Integer id) {
        return pacientRepository.findById(id)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacient> updatePacient(@PathVariable Integer id, @RequestBody Pacient updatedPacient) {
        return pacientRepository.findById(id)
                .map(pacient -> {
                    pacient.setNume(updatedPacient.getNume());
                    pacient.setPrenume(updatedPacient.getPrenume());
                    pacient.setVarsta(updatedPacient.getVarsta());
                    pacient.setCnp(updatedPacient.getCnp());
                    return ResponseEntity.ok(pacientRepository.save(pacient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacient(@PathVariable Integer id) {
        if (pacientRepository.existsById(id)) {
            pacientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
