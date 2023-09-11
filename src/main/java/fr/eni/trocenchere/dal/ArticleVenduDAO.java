package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Retrait;

public interface ArticleVenduDAO {
	
	ArticleVendu insert (ArticleVendu nouveauArticleVendu);

	List<ArticleVendu> selectAll();
	
	void insert(Retrait nouveauRetrait);

	ArticleVendu encherir(int noArticle);

	Retrait selectRetraitByNoArticle(int noArticle);
	
}