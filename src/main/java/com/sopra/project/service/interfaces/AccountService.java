package com.sopra.project.service.interfaces;


import com.sopra.project.model.*;

public interface AccountService {

	public User saveUser(User user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public User findUserByUsername(String username);
	public User findUserById(Long id);

}
