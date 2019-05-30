package com.sopra.project.param;

public class DisableParam {
	private String username;
	private int id;
	private Boolean disable;
	private String projetname;
	private Boolean projetDisable;


	
	public Boolean getProjetDisable() {
		return projetDisable;
	}
	public void setProjetDisable(Boolean projetDisable) {
		this.projetDisable = projetDisable;
	}
	public String getProjetname() {
		return projetname;
	}
	public void setProjetname(String projetname) {
		this.projetname = projetname;
	}
	public DisableParam() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getDisable() {
		return disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
