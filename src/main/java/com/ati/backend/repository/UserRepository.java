package com.ati.backend.repository;

import com.ati.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfață care oferă automat metode CRUD (findAll, findById, save etc.)
public interface UserRepository extends JpaRepository<User, Integer> {
}
