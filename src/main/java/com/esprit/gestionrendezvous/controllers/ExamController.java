package com.esprit.gestionrendezvous.controllers;

import com.esprit.gestionrendezvous.entities.Clinique;
import com.esprit.gestionrendezvous.entities.Medecin;
import com.esprit.gestionrendezvous.entities.Patient;
import com.esprit.gestionrendezvous.entities.RendezVous;
import com.esprit.gestionrendezvous.entities.Specialite;
import com.esprit.gestionrendezvous.services.IExamService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Tag(name = "Exam", description = "ExamAPIs")
@RestController
public class ExamController {

    @Autowired
    private IExamService examService;

    @Operation(description = " add Medecin  And Assign To Clinique ")
    @PostMapping(value = "/medecin/add/{cliniqueId}")
    public void addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long cliniqueId) {
        examService.addMedecinAndAssignToClinique(medecin, cliniqueId);

    }

    @Operation(description = " add clinique ")
    @PostMapping(value = "/clinique/add")
    public void addClinique(@RequestBody Clinique clinique) {
        examService.addClinique(clinique);
    }

    @Operation(description = " add patient ")
    @PostMapping(value = "/patient/add")
    public void addPatient(@RequestBody Patient patient) {
        examService.addPatient(patient);
    }


    // * Add RendezVous and assign Medecin and Patient
    @Operation(description = " add RDV and assign Medecin and Patient ")
    @PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable Long idMedecin,
        @PathVariable Long idPatient) {
            examService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }


    // * Get RendezVous By Clinique And Specialite
    @Operation(description = " get RendezVous By Clinique And Specialite ")
    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @PathVariable Specialite specialite) {
       return  examService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }
 
    // * Get Nbr RendezVous Medecin

    @Operation(description = " get Nbr RendezVous Medecin ")
    @GetMapping("/getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin) {
        return examService.getNbrRendezVousMedecin(idMedecin);
        
    }

    // * Get Revenu Medecin

    @Operation(description = " get Revenu Medecin ")
    @GetMapping("/getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable Long idMedecin, @PathVariable  @DateTimeFormat(pattern= "yyyy-MM-dd") Date startDate, @PathVariable  @DateTimeFormat(pattern= "yyyy-MM-dd") Date endDate) {
        return examService.getRevenuMedecin(idMedecin, startDate, endDate);
    }

  




}
