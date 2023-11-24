package com.personnages.donjonsdragonsspringboot.dao;

import com.personnages.donjonsdragonsspringboot.model.Personnages;

import java.util.List;

public interface PersonnagesDao {
    List<Personnages> findAll();
    Personnages findById(int id);
    Personnages save(Personnages personnages);
}
