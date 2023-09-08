package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.bo.Categorie;

public interface CategorieDAO {
		
	List<Categorie> selectAll();
	
	void insert (Categorie nouvelleCategorie);
	
	Categorie selectCategorieById(int noCategorie);

	void updateCategorie(Categorie categorie);

	void delete(int noCategorie);	
	
}
