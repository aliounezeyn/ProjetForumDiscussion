package com.formation.msglc.metier;

import java.util.List;

import com.formation.msglc.entities.Auteur;
import com.formation.msglc.entities.AuteurRole;
import com.formation.msglc.entities.Categorie;
import com.formation.msglc.entities.Reponse;
import com.formation.msglc.entities.SousCategorie;
import com.formation.msglc.entities.Suggestion;
import com.formation.msglc.entities.Sujet;
import com.formation.msglc.entities.Tag;

public interface IForumMetier {
	public Auteur addAuteur(Auteur auteur);
	public Auteur getAuteur(Long id);
	public void deleteAuteur(Long id);
	public Auteur updateAuteur(Auteur auteur);
	public List<Auteur> getAllAuteurs();
	public List<Auteur> getAuteursMC(String mc);
	public Auteur updateRole(Long id, AuteurRole role);
	public List<Auteur> getAuteurByRole(AuteurRole role);
	
	public Categorie addCategorie(Categorie categorie);
	public Categorie getCategorie(Long id);
	public List<Categorie> getAllCategories();
	public List<Categorie> getCategoriesMC(String mc);
	public List<Categorie> getCategoriesToValidate();
	public Categorie validerCategorie(Long id);
	
	public SousCategorie addSousCategorie(SousCategorie sousCategorie);
	public SousCategorie getSousCategorie(Long id);
	public List<SousCategorie> getAllSousCategories();
	public List<SousCategorie> getSousCategoriesMC(String mc);
	public List<SousCategorie> getSousCategoriesToValidate();
	public SousCategorie validerSousCategorie(Long id);  //<-----------------
	public List<SousCategorie> getSousCategoriesByCategorie(Long idCategorie);
	
	public Sujet addSujet(Sujet sujet);
	public Sujet getSujet(Long id);
	public List<Sujet> getSujetBySousCategorie(Long idSousCategorie);
	public List<Sujet> getSujetByAuteur(Long idAuteur);
	public List<Sujet> getSujetsToValidate();
	public Sujet validerSujet(Long id);
	
	public Reponse addReponse(Reponse reponse);
	public Reponse getReponse(Long id);
	public List<Reponse> getReponseBySujet(Long idSujet);
	public List<Reponse> getReponsesToValidate();
	public Reponse validerReponse(Long id);
	public List<Reponse> getReponseByAuteur(Long idAuteur);
	
	public Auteur testeLogin(String email, String password);
	
	//operations sur les suggestions
	public Suggestion addSuggestion(Suggestion suggestion);
	public List<Suggestion> addSuggestions(Sujet sujet);
	public Suggestion getSuggestion(Long id);
	public List<Suggestion> getSuggestionsBySujet(Long idSujet);
	public List<Suggestion> getSuggestionsToValidate();
	public Suggestion validerSuggestion(Long id);

	//Operations sur les Tag(mots-cle)
	public Tag addTag(Tag tag);
	public List<Tag> addTags(Sujet sujet);
	public Tag getTag(Long id);
	public List<Tag> getTagsBySujet(Long idSujet);
	public List<Tag> getTagsToValidate();
	public Tag validerTag(Long id);
	
	

}
