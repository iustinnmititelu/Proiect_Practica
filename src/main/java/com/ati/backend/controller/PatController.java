package com.ati.backend.controller;

import com.ati.backend.model.Pat;
import com.ati.backend.repository.PatRepository;
import com.ati.backend.repository.SpitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paturi")
public class PatController {

    @Autowired
    private PatRepository patRepository;

    @Autowired
    private SpitalRepository spitalRepository;

    @GetMapping
    public List<Pat> getAllPaturi() {
        return patRepository.findAll();
    }

    @PostMapping
    public Pat createPat(@RequestBody Pat pat) {
        return patRepository.save(pat);
    }
}
