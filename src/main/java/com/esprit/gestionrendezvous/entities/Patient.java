package com.esprit.gestionrendezvous.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPatient",nullable = false)
    private long idPatient;
    private String nomPatient;
    private int telephone;
    private Date dateNaissance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
   

    private Set<RendezVous> rendezVous;



}
