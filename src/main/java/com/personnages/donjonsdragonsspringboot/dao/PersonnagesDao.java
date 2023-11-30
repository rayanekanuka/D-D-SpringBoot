package com.personnages.donjonsdragonsspringboot.dao;

import com.personnages.donjonsdragonsspringboot.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnagesDao extends JpaRepository<Personnage, Integer> {
    List<Personnage> findAll();
    Personnage findById(int id);
    Personnage save(Personnage personnages);
    void deleteById(int id);
//    Personnage updateById(int id, Personnage personnage);
    Personnage updateByIdAndNom(int id, Personnage perso, String nom);
}
