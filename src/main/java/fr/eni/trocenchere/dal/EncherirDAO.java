package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.bo.Enchere;

public interface EncherirDAO {
	void insert(Enchere nouvelleEnchere);
	
	Enchere SelectEnchereByNo(int noArticle); 
	
}
