package com.esprit.gestionrendezvous.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMedecin",nullable = false)
    private long idMedecin;
    private String nomMedecin;
    private Specialite specialite;
    private int telephone;
    private int prixConsultation;

    @ManyToMany(mappedBy="medecins", cascade = CascadeType.ALL)


    private Set<Clinique> cliniques;


    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)

    private Set<RendezVous> rendezVous;



}
