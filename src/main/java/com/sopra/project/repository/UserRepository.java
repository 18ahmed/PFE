package com.sopra.project.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.project.model.*;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
	public User findByUsername(String username);
	@Query("SELECT p FROM User p WHERE p.enabled is true")
	public User findByUsernameActive(String username);
	@Query("SELECT p FROM User p  inner join p.roles r WHERE r= :role ")
	public List<User> findUserByRole(@Param("role") AppRole role);

	@Query("SELECT p FROM User p WHERE p.profil = :profil ")
	public List<User> getusersbyprofil(@Param("profil") String profil);

	public User findById(Long id);
	
	@Query("SELECT p FROM User p ")
	public List<User> getusers();
	
}
