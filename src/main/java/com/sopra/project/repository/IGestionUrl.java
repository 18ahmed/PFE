package com.sopra.project.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.project.model.GestionUrl;


public interface IGestionUrl extends JpaRepository<GestionUrl, Long> {
	

}
