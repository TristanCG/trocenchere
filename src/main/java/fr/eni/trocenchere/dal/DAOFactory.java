package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.EncherirDAOJdbcImpl;


public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}

	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	
	public static EncherirDAO getEnchereDAO() {
		return new EncherirDAOJdbcImpl(); 
	}
}
