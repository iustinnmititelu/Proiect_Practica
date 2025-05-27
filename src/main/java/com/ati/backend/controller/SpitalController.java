package com.ati.backend.controller;

import com.ati.backend.model.Spital;
import com.ati.backend.repository.SpitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spitale")
public class SpitalController {

    @Autowired
    private SpitalRepository spitalRepository;

    @GetMapping
    public List<Spital> getAllSpitale() {
        return spitalRepository.findAll();
    }

    @PostMapping
    public Spital createSpital(@RequestBody Spital spital) {
        return spitalRepository.save(spital);
    }
    @PutMapping("/{id}")
    public Spital updateSpital(@PathVariable Integer id, @RequestBody Spital updatedSpital) {
        return spitalRepository.findById(id).map(spital -> {
            spital.setNume(updatedSpital.getNume());
            spital.setZona(updatedSpital.getZona());
            spital.setCapacitateTotala(updatedSpital.getCapacitateTotala());
            spital.setContact(updatedSpital.getContact());
            return spitalRepository.save(spital);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSpital(@PathVariable Integer id) {
        spitalRepository.deleteById(id);
    }

}
