package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
}
