package com.esprit.gestionrendezvous.repositories;

import com.esprit.gestionrendezvous.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
}
