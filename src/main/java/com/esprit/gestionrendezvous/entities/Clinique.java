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
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClinique",nullable = false)
    private long idClinique;
    private String nomClinique;
    private String adresse;
    private int telephone;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Medecin> medecins;
  


}
