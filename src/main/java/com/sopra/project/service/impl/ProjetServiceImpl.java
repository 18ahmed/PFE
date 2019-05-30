package com.sopra.project.service.impl;

import com.sopra.project.model.Projet;
import com.sopra.project.repository.ProjetRepository;
import com.sopra.project.service.interfaces.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author M
 */
@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    ProjetRepository projetRepository;

    @Override
    public void addProjet(Projet projet) {
        projetRepository.save(projet);
    }

    @Override
    public void editProjet(Projet projet) {
        projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepository.delete(id);
    }

    @Override
    public Projet getProjetById(Long id) {
        return projetRepository.findById(id);
    }

    @Override
    public Projet getProjetByName(String name) {
        return projetRepository.findByName(name);
    }

    @Override
    public List<Projet> getAll() {
        return projetRepository.findAll();
    }
}
