package com.formation.msglc.metier;

import java.util.ArrayList;
import java.util.List;

import com.formation.msglc.dao.IForumDao;
import com.formation.msglc.entities.Auteur;
import com.formation.msglc.entities.AuteurRole;
import com.formation.msglc.entities.Categorie;
import com.formation.msglc.entities.Reponse;
import com.formation.msglc.entities.SousCategorie;
import com.formation.msglc.entities.Suggestion;
import com.formation.msglc.entities.Sujet;
import com.formation.msglc.entities.Tag;

public class ForumMetierImpl implements IForumMetier{

	private IForumDao dao;
	
	
	public IForumDao getDao() {
		return dao;
	}

	public void setDao(IForumDao dao) {
		this.dao = dao;
	}

	public Auteur addAuteur(Auteur auteur) {
		return dao.addAuteur(auteur);
	}

	@Override
	public Auteur getAuteur(Long id) {
		return dao.getAuteur(id);
	}

	@Override
	public void deleteAuteur(Long id) {
		dao.deleteAuteur(id);
		
	}

	@Override
	public Auteur updateAuteur(Auteur auteur) {
		return dao.updateAuteur(auteur);
	}

	@Override
	public List<Auteur> getAllAuteurs() {
		return dao.getAllAuteurs();
	}

	@Override
	public List<Auteur> getAuteursMC(String mc) {
		return dao.getAuteursMC(mc);
	}

	@Override
	public Auteur updateRole(Long id, AuteurRole role) {
		return dao.updateRole(id, role);
	}

	@Override
	public List<Auteur> getAuteurByRole(AuteurRole role) {
		return dao.getAuteurByRole(role);
	}

	@Override
	public Categorie addCategorie(Categorie categorie) {
		return dao.addCategorie(categorie);
	}

	@Override
	public Categorie getCategorie(Long id) {
		return dao.getCategorie(id);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return dao.getAllCategories();
	}

	@Override
	public List<Categorie> getCategoriesMC(String mc) {
		return dao.getCategoriesMC(mc);
	}

	@Override
	public List<Categorie> getCategoriesToValidate() {
		return dao.getCategoriesToValidate();
	}

	@Override
	public Categorie validerCategorie(Long id) {
		return dao.validerCategorie(id);
	}

	@Override
	public SousCategorie addSousCategorie(SousCategorie sousCategorie) {
		return dao.addSousCategorie(sousCategorie);
	}

	@Override
	public SousCategorie getSousCategorie(Long id) {
		return dao.getSousCategorie(id);
	}

	@Override
	public List<SousCategorie> getAllSousCategories() {
		return dao.getAllSousCategories();
	}

	@Override
	public List<SousCategorie> getSousCategoriesMC(String mc) {
		return dao.getSousCategoriesMC(mc);
	}

	@Override
	public List<SousCategorie> getSousCategoriesToValidate() {
		return dao.getSousCategoriesToValidate();
	}

	@Override
	public SousCategorie validerSousCategorie(Long id) {
		return dao.validerSousCategorie(id);
	}

	@Override
	public List<SousCategorie> getSousCategoriesByCategorie(Long idCategorie) {
		return dao.getSousCategoriesByCategorie(idCategorie);
	}

	@Override
	public Sujet addSujet(Sujet sujet) {
		return dao.addSujet(sujet);
	}

	@Override
	public Sujet getSujet(Long id) {
		return dao.getSujet(id);
	}

	@Override
	public List<Sujet> getSujetBySousCategorie(Long idSousCategorie) {
		return dao.getSujetBySousCategorie(idSousCategorie);
	}

	@Override
	public List<Sujet> getSujetByAuteur(Long idAuteur) {
		return dao.getSujetByAuteur(idAuteur);
	}

	@Override
	public List<Sujet> getSujetsToValidate() {
		return dao.getSujetsToValidate();
	}

	@Override
	public Sujet validerSujet(Long id) {
		return dao.validerSujet(id);
	}

	@Override
	public Reponse addReponse(Reponse reponse) {
		return dao.addReponse(reponse);
	}

	@Override
	public Reponse getReponse(Long id) {
		return dao.getReponse(id);
	}

	@Override
	public List<Reponse> getReponseBySujet(Long idSujet) {
		return dao.getReponseBySujet(idSujet);
	}

	@Override
	public List<Reponse> getReponsesToValidate() {
		return dao.getReponsesToValidate();
	}

	@Override
	public Reponse validerReponse(Long id) {
		return dao.validerReponse(id);
	}

	@Override
	public List<Reponse> getReponseByAuteur(Long idAuteur) {
		return dao.getReponseByAuteur(idAuteur);
	}

	@Override
	public Auteur testeLogin(String email, String password) {
		return dao.testeLogin(email, password);
	}
	
	
	//AZ modif BEGIN
	//
	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		
		return dao.addSuggestion(suggestion);
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		return dao.getSuggestion(id);
	}

	@Override
	public List<Suggestion> getSuggestionsBySujet(Long idSujet) {
		return dao.getSuggestionsBySujet(idSujet);
	}

	@Override
	public List<Suggestion> getSuggestionsToValidate() {
		return dao.getSuggestionsToValidate();
	}

	@Override
	public Suggestion validerSuggestion(Long id) {
		return dao.validerSuggestion(id);
	}

	@Override
	public Tag addTag(Tag tag) {
		return dao.addTag(tag);
	}

	@Override
	public Tag getTag(Long id) {
		return dao.getTag(id);
	}

	@Override
	public List<Tag> getTagsBySujet(Long idSujet) {
		return dao.getTagsBySujet(idSujet);
	}

	@Override
	public List<Tag> getTagsToValidate() {
		return dao.getTagsToValidate();
	}

	@Override
	public Tag validerTag(Long id) {
		return dao.validerTag(id);
	}

	//generation des suggestions
	public List<Suggestion> generateSuggestions(Sujet sujet){
		//List<Suggestion> suggestions;
		List<SousCategorie> categories = dao.getAllSousCategories();
		
		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		
		String [] sujetSplited = sujet.getContenu().split(" ");
		for(int i=0;i<sujetSplited.length;i++) {
			
			//des mots unitiles.. 
			if(sujetSplited[i].contentEquals("de")) continue;
			if(sujetSplited[i].contentEquals("des")) continue;
			if(sujetSplited[i].contentEquals("le")) continue;
			if(sujetSplited[i].contentEquals("la")) continue;
			if(sujetSplited[i].contentEquals("les")) continue;
			if(sujetSplited[i].contentEquals("a")) continue;
			if(sujetSplited[i].contentEquals("au")) continue;
			if(sujetSplited[i].contentEquals("aux")) continue;
			if(sujetSplited[i].contentEquals("un")) continue;
			if(sujetSplited[i].contentEquals("une")) continue;
			if(sujetSplited[i].contentEquals("qui")) continue;
			if(sujetSplited[i].contentEquals("que")) continue;
			if(sujetSplited[i].contentEquals("en")) continue;
			if(sujetSplited[i].contentEquals("dans")) continue;
			if(sujetSplited[i].contentEquals("y")) continue;
			if(sujetSplited[i].contentEquals("Y")) continue;
			if(sujetSplited[i].contentEquals("configuration")) continue;
			if(sujetSplited[i].contentEquals("solution")) continue;
			
			//verification et comparaison
			for(int j=0;j<categories.size();j++) {
				//System.out.print(" ["+categories.get(j) + "] ");
				/*
				String patternString = ".*(?!"+sujetSplited[i]+").*";
				Pattern pattern = Pattern.compile(patternString);
				Matcher matcher = pattern.matcher(categories.get(j));
		        boolean matches = matcher.matches();
		        if(matches){
		        */
				
				if(categories.get(j).getDescription().equals(sujetSplited[i]) || categories.get(j).getDescription().contains(" "+sujetSplited[i]) || categories.get(j).getDescription().contains(sujetSplited[i]+" ") || categories.get(j).getDescription().contains("-"+sujetSplited[i]) || categories.get(j).getDescription().contains(sujetSplited[i]+"-")){
					Suggestion sug = new Suggestion(sujet,categories.get(j).getCategorie(),categories.get(j),true);
					boolean skip=false;
					for(int counter = 0; counter<suggestions.size();counter++) {
						if(suggestions.get(counter).getCategorie().getId()==categories.get(j).getId()) {
							skip=true;
							break;
						}
					}
					if(skip) continue;
					/*List<SousCategorie> sousCat = dao.getSousCategoriesByCategorie(categories.get(j).getId());
					for(int k=0;k<sousCat.size();i++) {
						suggestions.add(new Suggestion(sujet,categories.get(j),sousCat.get(k),true));
					}*/
					
					suggestions.add(sug);
					System.out.println("*************************"+sujetSplited[i]);
				}
			}
			
			
		}
		
		
		return suggestions;
	}
	
	@Override
	public List<Suggestion> addSuggestions(Sujet sujet) {
		List<Suggestion> suggestions = generateSuggestions(sujet);
		for(int i=0;i<suggestions.size();i++) {
			this.addSuggestion(suggestions.get(i));
		}
		if(suggestions.isEmpty())return null;
		return (List<Suggestion>)this.getSuggestionsBySujet(suggestions.get(0).getSujet().getId());
	}

	//generation des tags
	public List<Tag> generateTags(Sujet sujet){
		List<Tag> tags = new ArrayList<Tag>();
		List<Categorie> categories = dao.getAllCategories();

		String [] sujetSplited = sujet.getContenu().split(" ");
		for(int i=0;i<sujetSplited.length;i++) {
			
			//des mots unitiles.. 
			if(sujetSplited[i].contentEquals("de")) continue;
			if(sujetSplited[i].contentEquals("des")) continue;
			if(sujetSplited[i].contentEquals("le")) continue;
			if(sujetSplited[i].contentEquals("la")) continue;
			if(sujetSplited[i].contentEquals("les")) continue;
			if(sujetSplited[i].contentEquals("a")) continue;
			if(sujetSplited[i].contentEquals("au")) continue;
			if(sujetSplited[i].contentEquals("aux")) continue;
			if(sujetSplited[i].contentEquals("un")) continue;
			if(sujetSplited[i].contentEquals("une")) continue;
			if(sujetSplited[i].contentEquals("qui")) continue;
			if(sujetSplited[i].contentEquals("que")) continue;
			if(sujetSplited[i].contentEquals("en")) continue;
			if(sujetSplited[i].contentEquals("dans")) continue;
			if(sujetSplited[i].contentEquals("y")) continue;
			if(sujetSplited[i].contentEquals("Y")) continue;
			if(sujetSplited[i].contentEquals("configuration")) continue;
			if(sujetSplited[i].contentEquals("solution")) continue;
			
			//verification et comparaison
			for(int j=0;j<categories.size();j++) {
				//System.out.print(" ["+categories.get(j) + "] ");
				/*
				String patternString = ".*(?!"+sujetSplited[i]+").*";
				Pattern pattern = Pattern.compile(patternString);
				Matcher matcher = pattern.matcher(categories.get(j));
		        boolean matches = matcher.matches();
		        if(matches){
		        */
				
				if(categories.get(j).getDescription().equals(sujetSplited[i]) || categories.get(j).getDescription().contains(" "+sujetSplited[i]) || categories.get(j).getDescription().contains(sujetSplited[i]+" ") || categories.get(j).getDescription().contains("-"+sujetSplited[i]) || categories.get(j).getDescription().contains(sujetSplited[i]+"-")){
					if(tags.contains(categories.get(j))) continue;
				
					tags.add(new Tag(sujet,sujetSplited[i],true));
				
					
					System.out.println(sujetSplited[i]);
				}
			}
			
			
		}
		
		return tags;
	}
	@Override
	public List<Tag> addTags(Sujet sujet) {
		List<Tag> tags = generateTags(sujet);
		for(int i=0;i<tags.size();i++) {
			this.addTag(tags.get(i));
		}
		return this.getTagsBySujet(tags.get(0).getSujet().getId());
	}

}
