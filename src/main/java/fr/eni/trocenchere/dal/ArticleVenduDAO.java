package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	void insert (ArticleVendu nouveauArticleVendu);

	List<ArticleVendu> selectAll(); 
	
}
