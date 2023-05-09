package com.esprit.gestionrendezvous.services;

import com.esprit.gestionrendezvous.entities.*;
import com.esprit.gestionrendezvous.repositories.CliniqueRepository;
import com.esprit.gestionrendezvous.repositories.MedecinRepository;
import com.esprit.gestionrendezvous.repositories.PatientRepository;
import com.esprit.gestionrendezvous.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ExamServiceImpl implements IExamService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private CliniqueRepository cliniqueRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RendezVousRepository rdvRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        // * Ajout Medecin
        Medecin createdMedecin = medecinRepository.save(medecin);
        Assert.notNull(createdMedecin, "Medecin not created");

        // * Affectation
        Clinique clinique = cliniqueRepository.findById(cliniqueId).get();

        clinique.getMedecins().add(createdMedecin);

        // * Update f base
        cliniqueRepository.save(clinique);

        return createdMedecin;
    }

    @Override
    public void addPatient(Patient patient) {

        patientRepository.save(patient);

    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        // * Ajout RDV
        RendezVous createdRDV = rdvRepository.save(rdv);
        Assert.notNull(createdRDV, "RDV not created");

        // * Recherche Medecin
        Medecin medecin = medecinRepository.findById(idMedecin).get();

        // * Recherche Patient
        Patient patient = patientRepository.findById(idPatient).get();

        // * Affectation

        createdRDV.setMedecin(medecin);
        createdRDV.setPatient(patient);

        // * Update f base

        rdvRepository.save(createdRDV);

    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {

        return rdvRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique, specialite);

    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {

        return rdvRepository.countByMedecinIdMedecin(idMedecin);

    }

    @Scheduled(cron = "0 */15 * ? * *")
    public void retrieveRendezVous() {

        List<RendezVous> rdvs = rdvRepository.findAll();
        for (RendezVous rdv : rdvs) {

            System.out.println("la liste des RendezVous :"
                    + rdv.getDateRDV() + ": Medecin :"
                    + rdv.getMedecin().getNomMedecin() +
                    ": patient: " + rdv.getPatient().getNomPatient());
        }
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
      
        RendezVous rdv = rdvRepository.findByMedecinIdMedecinAndDateRDVBetween(idMedecin, startDate, endDate);
        if (rdv == null) {
            return 0;
        }

        int revenu = rdv.getMedecin().getPrixConsultation() * rdvRepository.countByMedecinIdMedecin(idMedecin);
        return revenu;

    }

}
