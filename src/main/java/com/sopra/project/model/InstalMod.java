package com.sopra.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class InstalMod {

	
	
	@Id
    @GeneratedValue
    private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InstalMod(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public InstalMod(String name) {
		super();
		this.name = name;
	}
	public InstalMod() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
