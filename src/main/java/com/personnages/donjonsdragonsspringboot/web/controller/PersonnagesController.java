package com.personnages.donjonsdragonsspringboot.web.controller;

import com.personnages.donjonsdragonsspringboot.dao.PersonnagesDao;
import com.personnages.donjonsdragonsspringboot.model.Personnages;
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
    public List<Personnages> listePersonnages() {
        return personnagesDao.findAll();
    }

    /**
     * Lit le personnage identifié par un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Personnages/{id}")
    public Personnages afficherUnPersonnage(@PathVariable int id) {
        return personnagesDao.findById(id);
    }

    @PostMapping(value = "Personnages")
    public Personnages ajouterUnPersonnage(@RequestBody Personnages personnages) {
        return personnagesDao.save(personnages);
    }
q
//    @PutMapping(value = "Personnages")
//    public Personnages modifierUnPersonnage(@RequestBody Personnages personnages) {
//        return personnagesDao.modyfiById(personnages);
//    }
}
