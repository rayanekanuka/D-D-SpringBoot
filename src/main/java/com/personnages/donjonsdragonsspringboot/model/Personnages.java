package com.personnages.donjonsdragonsspringboot.model;

public class Personnages {
    private int id;
    private String nom;
    private String type;
    private int vie;

    public Personnages(int id, String nom, String type, int vie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.vie = vie;
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
