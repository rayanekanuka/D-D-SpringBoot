package com.personnages.donjonsdragonsspringboot.web.controller;

import com.personnages.donjonsdragonsspringboot.dao.PersonnagesDao;
import com.personnages.donjonsdragonsspringboot.model.Personnage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController indique que cette classe va pouvoir traiter les requêtes que nous allons définir.
 * Il indique aussi que chaque méthode va renvoyer directement la réponse JSON à l'utilisateur
 */
@RestController
public class PersonnagesController {
    private final PersonnagesDao personnagesDao;

    public PersonnagesController(PersonnagesDao personnagesDao) {
        this.personnagesDao = personnagesDao;
    }

    /**
     * Lit toute la liste des personnages
     * @return les infos des personnages
     */

    @GetMapping("/Personnages")
    public List<Personnage> listePersonnages() {
        return personnagesDao.findAll();
    }

    /**
     * Lit le personnage identifié par un id
     * @param id
     * @return
     */
    @GetMapping("/Personnages/{id}")
    public Personnage afficherUnPersonnage(@PathVariable int id) {
        return personnagesDao.findById(id);
    }

    /**
     * Ajoute un personnage
     * @param personnages
     * @return
     */
    @PostMapping("/Personnages")
    public Personnage ajouterUnPersonnage(@RequestBody Personnage personnages) {
        return personnagesDao.save(personnages);
    }

    /**
     * Modifie un personnage identifié par un id
     * @param id
     * @return
     */
    @PutMapping("/Personnages/{id}")
    public Personnage modifierUnPersonnage(@PathVariable int id, @RequestBody Personnage personnage) {
        return personnagesDao.updateById(id, personnage);
    }

    /**
     * Supprime un personnage identifié par un id
     * @param id
     * @return
     */

    @DeleteMapping("/Personnages/{id}")
    public void supprimerUnPersonnage(@PathVariable int id) {
        personnagesDao.deleteById(id);
    }
}
