package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.DAOFactory;

public class CategorieManger {
	
	private static CategorieManger instance ; 
	
	public static CategorieManger getInstance() {
		
		if (instance == null ) {
			instance = new CategorieManger (); 
		
		}
		
		return instance ; 
		
	}

	private CategorieManger () {
		
	}
	
	
	public Categorie insert (String libelle) {
		
		Categorie nouvelleCategorie = new Categorie(libelle); 
		System.out.println(nouvelleCategorie); 
		DAOFactory.getCategorieDAO().insert(nouvelleCategorie);
		
		return nouvelleCategorie; 
	}
}
