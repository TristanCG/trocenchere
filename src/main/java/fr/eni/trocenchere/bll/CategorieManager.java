package fr.eni.trocenchere.bll;

import java.util.List;

import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.DAOFactory;

public class CategorieManager {
	
	//Singleton
	private static CategorieManager instance ; 
	
	public static CategorieManager getInstance() {
		
		if (instance == null ) {
			instance = new CategorieManager (); 
		
		}
		
		return instance ; 
		
	}

	private CategorieManager () {
		
	}
	//Fin Singleton
	
	public List<Categorie> selectAll(){
		return DAOFactory.getCategorieDAO().selectAll();
	}
	
	public Categorie insert (String libelle) {
		
		Categorie nouvelleCategorie = new Categorie(libelle); 
		System.out.println(nouvelleCategorie); 
		DAOFactory.getCategorieDAO().insert(nouvelleCategorie);
		
		return nouvelleCategorie; 
	}
}
