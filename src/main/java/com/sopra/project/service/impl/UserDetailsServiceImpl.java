package com.sopra.project.service.impl;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.project.service.interfaces.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	
	//@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.sopra.project.model.User u = accountService.findUserByUsername(username);
		if (u == null) throw new UsernameNotFoundException(username);
		System.out.println("**************************************test utilisateur active ou non:"+u.isEnabled()+"************************************************************");
		if(!u.isEnabled()) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		u.getRoles().forEach(r->{
			System.out.println("**************************************UserDetailsRole: "+ r.getRoleName()+"************************************************************");

			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		
		

		return new User(u.getUsername(),u.getPassword(),authorities);
		
	}

	
}
