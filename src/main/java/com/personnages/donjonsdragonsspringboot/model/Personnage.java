package com.personnages.donjonsdragonsspringboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Entity
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema (name = "id", example = "1", required = true)
    private int id;
    @Schema (name = "nom", example = "Massimo")
    private String nom;
    @Schema (name = "type", example = "Guerrier")
    private String type;
    @Schema (name = "life", example = "15")
    @Column (name = "life", nullable = false)
    private int vie;

    public Personnage(int id, String nom, String type, int vie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.vie = vie;
    }

    public Personnage() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    @Override
    public String toString() {
        return "Personnages {" +
                "id =" + id +
                ", nom ='" + nom + '\'' +
                ", vie =" + vie +
                '}';
    }

}
