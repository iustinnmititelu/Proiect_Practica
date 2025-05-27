package com.ati.backend.repository;

import com.ati.backend.model.Pat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatRepository extends JpaRepository<Pat, Integer> {
}
