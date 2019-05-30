package com.sopra.project.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author M
 */
@Entity
public class Projet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date date_debut;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_fin;
    
   


	@Column(name = "enabled")
	private boolean enabled  ;

    

    @ManyToOne
    @JoinColumn
	private User user;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	
	public boolean getEnabled() {
		return enabled;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDate_debut() {
		return date_debut;
	}



	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}



	public Date getDate_fin() {
		return date_fin;
	}



	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	 public boolean isEnabled() {
			return enabled;
		}



		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Projet(Long id, String name, String description, Date date_debut, Date date_fin,boolean enabled, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.enabled = enabled;
		this.user = user;
	}



	public Projet(String name, String description, Date date_debut, Date date_fin,boolean enabled, User user) {
		super();
		this.name = name;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.user = user;
		this.enabled = enabled;
	}



	public Projet(String name, String description, Date date_debut, Date date_fin, boolean enabled) {
		super();
		this.name = name;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.enabled = enabled;
	}



	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
   
    
   
}
