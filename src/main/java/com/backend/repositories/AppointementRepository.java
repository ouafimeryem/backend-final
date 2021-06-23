package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entities.Appointement;

import java.util.Optional;

public interface AppointementRepository extends JpaRepository< Appointement, Long> {
}
