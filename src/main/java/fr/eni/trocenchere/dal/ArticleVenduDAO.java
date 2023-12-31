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

	List<ArticleVendu> selectNomCategorie(String nomRecherche, int categorieRecherche, String typeRecherche, String achats1, String achats2, String achats3, String ventes1, String ventes2, String ventes3, int noUtilisateurSession);

	void delete(int noArticleVendu);

}