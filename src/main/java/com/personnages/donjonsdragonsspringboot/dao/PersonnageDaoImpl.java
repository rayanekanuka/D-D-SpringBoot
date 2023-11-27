package com.personnages.donjonsdragonsspringboot.dao;

import com.personnages.donjonsdragonsspringboot.model.Personnage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnageDaoImpl implements PersonnagesDao {
    public static List<Personnage> personnages = new ArrayList<>();

    static {
        personnages.add(new Personnage(1, "Thor", "Guerrier", 15));
        personnages.add(new Personnage(2, "Gandalf", "Magicien", 10));
        personnages.add(new Personnage(3, "Manu", "Guerrier", 15));
        personnages.add(new Personnage(4, "Massimo", "Magicien", 10));
    }

    @Override
    public List<Personnage> findAll() {

        return personnages;
    }

    @Override
    public Personnage findById(int id) {
        for (Personnage personnages : personnages) {
            if (personnages.getId() == id) {
                return personnages;
            }
        }
        return null;
    }

    @Override
    public Personnage save(Personnage personnage) {
        personnages.add(personnage);
        return personnage;
    }

    @Override
    public Personnage updateById(int id, Personnage personnage) {
        Personnage updatePersonnage = findById(id);
        updatePersonnage.setNom(personnage.getNom());
        updatePersonnage.setType(personnage.getType());
        updatePersonnage.setVie(personnage.getVie());
        return updatePersonnage;
    }

    @Override
    public void deleteById(int id) {
        personnages.removeIf(personnage -> personnage.getId() == id);
    }

}
