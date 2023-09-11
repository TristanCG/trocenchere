package fr.eni.trocenchere.bll;

import java.time.LocalDate;

import fr.eni.trocenchere.bo.Enchere;

public class EnchereManager {
	//Singleton
	private static EnchereManager instance;
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
	private EnchereManager() {
		
	}
	//Fin singleton
	
	public Enchere insert(LocalDate dateEnchere, int montantEnchere,int noArticle,int noUtilisateur) {
		Enchere nouvelleEnchere = new Enchere(dateEnchere,montantEnchere,noArticle,noUtilisateur);
		return nouvelleEnchere;
	}
}
