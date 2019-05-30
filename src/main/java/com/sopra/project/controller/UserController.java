package com.sopra.project.controller;



import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.project.model.*;
import com.sopra.project.param.DisableParam;
import com.sopra.project.repository.*;

@RestController
public class UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	

	@PostMapping("api/user/add")
	public @ResponseBody Map<String, Boolean> addUser(Model model, @RequestBody User user) {
		try {

			System.out.println(user.getPassword());
			String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(hashPW);
			
			user.setEnabled(true);
			userRepository.save(user);
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}

	}

	@GetMapping("api/user/getbyid")
	User getUserById(Long id) {

		return userRepository.findById(id);
	}
	
	@GetMapping("api/user/getAllUsers")
	 List<User> getAllUsers(Model model) {
		return userRepository.getusers();
	}

	@GetMapping("api/user/getall")
	 List<User> getallUser(Model model) {
		return userRepository.findAll();
	}

	@GetMapping("api/user/getbyusername")
	User findUserByUsername(Model model, String username) {
		return userRepository.findByUsername(username);
	}

	
	@PostMapping("api/user/remove")
	public @ResponseBody Map<String, Boolean> removeuser(Model model, @RequestBody List<String> usernames) {
		User utilisateurtodelete;
		try {
			System.out.println(usernames.size());
			for (int i = 0; i < usernames.size(); i++) {
				utilisateurtodelete = null;
				System.out.println(usernames.get(i));
				utilisateurtodelete = userRepository.findByUsername(usernames.get(i));
				if (utilisateurtodelete != null)

					userRepository.delete(utilisateurtodelete);

			}

			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}

	



	@PostMapping("api/user/update")
	public @ResponseBody Map<String, Boolean> updateuser(Model model, @RequestBody User user) {
		System.out.println();
		System.out.println(user.getUsername() + "***" + user.getTelephone() + "***" + user.getEmail());

		System.out.println();
		User utilisateurtoupdate = userRepository.findByUsername(user.getUsername());

		if (utilisateurtoupdate != null) {
			utilisateurtoupdate.setEmail(user.getEmail());
			utilisateurtoupdate.setTelephone(user.getTelephone());
			try {
				userRepository.save(utilisateurtoupdate);
				Map<String, Boolean> success = new TreeMap<String, Boolean>();
				success.put("response", true);
				return success;
			} catch (Exception e) {
				e.printStackTrace();
				Map<String, Boolean> echec = new TreeMap<String, Boolean>();
				echec.put("response", false);
				return echec;
			}
		} else {
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}

	
	@GetMapping("api/user/profil")
	public @ResponseBody List<User> getbyprofil(Model model, String profil) {

		return userRepository.getusersbyprofil(profil);
	}

	@GetMapping("api/user/byRole")
	public @ResponseBody List<User> getUserByRole(Model model, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		return userRepository.findUserByRole(role);
	}
	
	@PostMapping("api/user/disable")
	public @ResponseBody Map<String, Boolean> diableuser(Model model, @RequestBody DisableParam disableParam) {
		User utilisateur = userRepository.findByUsername(disableParam.getUsername());
		utilisateur.setEnabled(disableParam.getDisable());
		System.out.println(disableParam.getUsername() + disableParam.getDisable());
		try {
			userRepository.save(utilisateur);
			Map<String, Boolean> success = new TreeMap<String, Boolean>();
			success.put("response", true);
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Boolean> echec = new TreeMap<String, Boolean>();
			echec.put("response", false);
			return echec;
		}
	}



}
