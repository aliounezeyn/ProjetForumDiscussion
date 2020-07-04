package com.formation.msglc.entities;


//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Suggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSuggestion")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idSujet")
	private Sujet sujet;
	
	private boolean valide;
	
	@ManyToOne
	@JoinColumn(name = "idCategorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name = "idSousCategorie")
	private SousCategorie sousCategorie;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Sujet getSujet() {
		return sujet;
	}
	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
	public Suggestion() {
		super();
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public Suggestion(Sujet sujet,Categorie categorie,SousCategorie sousCategorie, //<-----
			boolean valide) {
		super();
		this.sujet = sujet;
		this.valide = valide;
		this.categorie=categorie;
		this.sousCategorie=sousCategorie;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Categorie getSousCategorie() {
		return categorie;
	}
	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}
	
	
	

}
