package com.sopra.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.project.model.AppRole;

public interface RoleRepository extends JpaRepository<AppRole,Long> {

	public AppRole findByRoleName(String roleName);
	}
