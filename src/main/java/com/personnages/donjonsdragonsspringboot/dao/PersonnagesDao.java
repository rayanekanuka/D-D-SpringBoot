package com.personnages.donjonsdragonsspringboot.dao;

import com.personnages.donjonsdragonsspringboot.model.Personnage;

import java.util.List;

public interface PersonnagesDao {
    List<Personnage> findAll();
    Personnage findById(int id);
    Personnage save(Personnage personnages);
    void deleteById(int id);
    Personnage updateById(int id, Personnage personnage);
}
