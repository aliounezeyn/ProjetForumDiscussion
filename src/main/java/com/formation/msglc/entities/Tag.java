package com.formation.msglc.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTag")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idSujet")
	private Sujet sujet;
	
	private boolean valide;
	
	@Column(length = 60)
	private String keyWord;
	
	
	
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
	public Tag() {
		super();
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public Tag(Sujet sujet,String keyWord, //<-----
			boolean valide) {
		super();
		this.sujet = sujet;
		this.valide = valide;
		this.keyWord=keyWord;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
	
	

}
