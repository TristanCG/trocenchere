package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.dal.ArticleVenduDAO;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial) VALUES(?,?,?,?,?);";


	@Override
	public void insert(ArticleVendu nouveauArticleVendu) {
			try(Connection cnx = ConnectionProvider.getConnection()) {
				// Insertion de l'utilisateur
				PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLE);
				pStmt.setString(1, nouveauArticleVendu.getNomArticle());
				pStmt.setString(2, nouveauArticleVendu.getDescription());
				pStmt.setDate(3, java.sql.Date.valueOf(nouveauArticleVendu.getDateDebutEncheres()));
				pStmt.setDate(4, java.sql.Date.valueOf(nouveauArticleVendu.getDateFinEncheres()));
				pStmt.setInt(5, nouveauArticleVendu.getPrixInitial());
				
				pStmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
