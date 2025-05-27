package com.ati.backend.repository;

import com.ati.backend.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Integer> {
}
