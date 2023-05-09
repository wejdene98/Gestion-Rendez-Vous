package com.esprit.gestionrendezvous.repositories;

import com.esprit.gestionrendezvous.entities.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
