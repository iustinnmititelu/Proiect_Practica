package com.ati.backend.controller;

import com.ati.backend.model.Rol;
import com.ati.backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roluri")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> getAllRoluri() {
        return rolRepository.findAll();
    }

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }
}
