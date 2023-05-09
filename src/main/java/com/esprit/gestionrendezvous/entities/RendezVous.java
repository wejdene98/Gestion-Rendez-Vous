package com.esprit.gestionrendezvous.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRDV",nullable = false)
    private long idRDV;
    private Date dateRDV;
    private String remarque;


    @ManyToOne
    @JsonIgnore
    private Medecin medecin;

    @ManyToOne
    @JsonIgnore
    private Patient patient;



}
