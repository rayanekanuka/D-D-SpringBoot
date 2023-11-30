package com.personnages.donjonsdragonsspringboot.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * @Entity nous indique que c'est cette classe est une classe persistante :
 * avec un attribut name, qui fixe le nom de l'entité
 * L'annotation @Table permet de fixer le nom de la table
 * dans laquelle les instances de cette classe vont être écrites.
 */

@Entity
@Table(name = "personnage")
public class Personnage {
    // permet de mapper une clé primaire sur un champ unique
    @Id
    /* @GeneratedValue sert pour l'auto-incrementation lors de l'insertion en base
    Cette annotation possède plusieurs attributs = strategy, generator.
    Il est possible de définir le mode de génération de la clé primaire à l'aide de l'attribut "strategy"
    Ici le GenerationType.AUTO : la génération de la clé primaire est laissée à l'implémentation
    C’est Hibernate qui s’en charge et qui crée une séquence unique sur tout le schéma via la table hibernate_sequence. */
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Schema sert pour la description en doc Swagger
    @Schema (name = "id", example = "1", required = true)
    // permet de préciser la colonne, ou peut aussi se placer sur un getter
    @Column (name = "id", nullable = false)
    @NotNull
    private int id;
    @Schema (name = "nom", example = "Massimo")
    @Column (name = "nom", nullable = false)
    @NotBlank (message = "Le nom est obligatoire")
    @Size(min = 3, max = 40, message = "Le nom doit être compris entre 3 et 40 caractères")
    private String nom;

    @Schema (name = "type", example = "Guerrier")
    @Column (name = "type", nullable = false)
    @NotBlank (message = "Le type est obligatoire")
    @Size(min = 3, max = 40, message = "Le type doit être compris entre 3 et 40 caractères")
    private String type;
    @Schema (name = "life", example = "15")
    @Column (name = "life", nullable = false)
    @NotNull
    @Min(value = 1, message = "Les points de vies ne peuvent pas être en-dessous de 3")
    @Max(value = 999, message = "Les points de vies ne peuvent pas être au-dessus de 999")
    @PositiveOrZero(message = "Attention action non autorisée")
    private int vie;

    // ----------------------------- CONSTRUCTEUR ------------------------------- //

    public Personnage() {

    }

    public Personnage(int id, String nom, String type, int vie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.vie = vie;
    }

    // ----------------------------- GETTER & SETTER ------------------------------- //


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
