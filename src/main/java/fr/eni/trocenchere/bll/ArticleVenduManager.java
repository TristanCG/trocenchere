package fr.eni.trocenchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.dal.ArticleVenduDAO;
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
		ArticleVendu nouveauArticleVendu = new ArticleVendu (nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, noUtilisateur, noCategorie); 

		System.out.println(nouveauArticleVendu);
		
		nouveauArticleVendu = DAOFactory.getArticleVenduDAO().insert(nouveauArticleVendu);
		
		return nouveauArticleVendu;
	}
	
	public List<ArticleVendu> selectAll() {
		return DAOFactory.getArticleVenduDAO().selectAll(); 
	}

	public void insert(ArticleVendu article, String rue, String codePostal, String ville) {
		Retrait nouveauRetrait = new Retrait(rue, codePostal, ville);
		System.out.println("Nouveau Retrait ArticleVenduManager");
		nouveauRetrait.setArticleVendu(article);
		DAOFactory.getArticleVenduDAO().insert(nouveauRetrait);
		
	}

	public ArticleVendu getArticleByNo(int noArticle) {
		ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
		return articleVenduDAO.encherir(noArticle);
	}

	public Retrait getRetraitByNo(int noArticle) {
		ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
		return articleVenduDAO.selectRetraitByNoArticle(noArticle);
	}

	public List<ArticleVendu> selectNomCategorie(String nomRecherche, int categorieRecherche) {
		return DAOFactory.getArticleVenduDAO().selectNomCategorie(nomRecherche, categorieRecherche); 
	}

	
}
