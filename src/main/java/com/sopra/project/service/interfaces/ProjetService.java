package com.sopra.project.service.interfaces;

import com.sopra.project.model.Projet;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

/**
 * @author 
 */
public interface ProjetService {

    public void addProjet(Projet projet);
    public void editProjet(Projet projet);
    public void deleteProjet(Long id);
    public Projet getProjetById(Long id);
    public Projet getProjetByName(String name);
	
    @Query("SELECT p FROM Projet p ")
    public List<Projet> getAll();
}
