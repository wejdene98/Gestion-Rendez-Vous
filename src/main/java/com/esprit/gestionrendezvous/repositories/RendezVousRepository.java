package com.esprit.gestionrendezvous.repositories;

import com.esprit.gestionrendezvous.entities.RendezVous;
import com.esprit.gestionrendezvous.entities.Specialite;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    public List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(Long idClinique, Specialite specialite);

    public int countByMedecinIdMedecin(Long idMedecin);

    public List<RendezVous> findByMedecinIdMedecin(long idMedecin);

    public RendezVous findByMedecinIdMedecinAndDateRDVBetween(Long idMedecin, Date startDate, Date endDate);


}
