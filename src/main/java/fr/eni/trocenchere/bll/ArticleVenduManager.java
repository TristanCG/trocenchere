package fr.eni.trocenchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.dal.DAOFactory;

public class ArticleVenduManager {
	
	//Singleton
	private static ArticleVenduManager instance;
	
	public static ArticleVenduManager getInstance() {
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
	
	private ArticleVenduManager() {
		
	}
	//Fin Singleton
	
	public ArticleVendu insert(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
		ArticleVendu nouveauArticleVendu = new ArticleVendu (nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, noUtilisateur ,noCategorie); 
		//Ici on retouve le constructeur de ArticleVendu
		
		System.out.println(nouveauArticleVendu);
		
		DAOFactory.getArticleVenduDAO().insert(nouveauArticleVendu);
		
		return nouveauArticleVendu;
	}
	
	public List<ArticleVendu> selectAll() {
		return DAOFactory.getArticleVenduDAO().selectAll(); 
	}

}
