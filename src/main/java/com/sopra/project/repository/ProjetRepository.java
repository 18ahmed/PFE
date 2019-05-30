package com.sopra.project.repository;

import com.sopra.project.model.Projet;
import com.sopra.project.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author M
 */
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    public Projet findById(long id);
    @Query("SELECT p FROM Projet p WHERE p.name = :name ")
    public Projet findByName(String name);


    @Query("SELECT p FROM Projet p")
	public List<Projet> getprojets();
    
    
}
