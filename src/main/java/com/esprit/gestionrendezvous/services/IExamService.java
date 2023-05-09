package com.esprit.gestionrendezvous.services;

import com.esprit.gestionrendezvous.entities.*;

import java.util.Date;
import java.util.List;

public interface IExamService {

    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public void addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    public int getNbrRendezVousMedecin(Long idMedecin);

    public void retrieveRendezVous();
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
