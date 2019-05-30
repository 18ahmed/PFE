package com.sopra.project.model;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AppRole {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String roleName;
	
	@ManyToMany(mappedBy = "roles",fetch=FetchType.EAGER)
	private Collection<AccessUrl> accessUrls  = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public AppRole(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection<AccessUrl> getAccessUrls() {
		return accessUrls;
	}
	public void setAccessUrls(Collection<AccessUrl> accessUrls) {
		this.accessUrls = accessUrls;
	}
	
}
