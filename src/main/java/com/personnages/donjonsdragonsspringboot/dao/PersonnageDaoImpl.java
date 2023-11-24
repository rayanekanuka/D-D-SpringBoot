package com.personnages.donjonsdragonsspringboot.dao;

import com.personnages.donjonsdragonsspringboot.model.Personnages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnageDaoImpl implements PersonnagesDao {
    public static List<Personnages> personnages = new ArrayList<>();

    static {
        personnages.add(new Personnages(1, "Thor", "Guerrier", 15));
        personnages.add(new Personnages(2, "Gandalf", "Magicien", 10));

    }

    @Override
    public List<Personnages> findAll() {

        return personnages;
    }

    @Override
    public Personnages findById(int id) {
        for (Personnages personnages : personnages) {
            if (personnages.getId() == id) {
                return personnages;
            }
        }
        return null;
    }

    @Override
    public Personnages save(Personnages personnage) {
        personnages.add(personnage);
        return personnage;
    }

//    @Override
//    public List<Personnages> modifyById(int id) {
//
//
//
//        String userName = String.valueOf(personnages.get(1));
//        Personnages superman = this.personnages.set(15);
//
//        return personnages;
//    }

}
