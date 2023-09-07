package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ArticleVenduDAO;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, "
			+ "date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?);";

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
				pStmt.setInt(6, nouveauArticleVendu.getPrixVente());
				pStmt.setInt(7, nouveauArticleVendu.getNoUtilisateur());
				pStmt.setInt(8, nouveauArticleVendu.getNoCategorie());
				
				pStmt.executeUpdate();
				
				//récupérer l'id et le mettre dans l'objet
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	private final static String SELECT_ALL_ARTICLE = "SELECT ARTICLES_VENDUS.*, UTILISATEURS.no_utilisateur, UTILISATEURS.pseudo, CATEGORIES.no_categorie\r\n"
			+ "FROM ARTICLES_VENDUS\r\n"
			+ "JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur\r\n"
			+ "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie;";

	@Override
	public List<ArticleVendu> selectAll() {
		List<ArticleVendu> articlesvendus = new ArrayList<ArticleVendu>(); 
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLE);
			
			int noArticlePrecedent = 0;
			ArticleVendu articlevendu = null; 
			while(rs.next()) {
				
				int noArticleEnCours = rs.getInt("no_article");
				if(noArticleEnCours != noArticlePrecedent) {
					String nomArticle = rs.getString("nom_article");
					//TODO La c'est prix initial, il faudra le prix de vente actuel après
					int prixInitial = rs.getInt("prix_initial"); 
					LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate(); 
					
					articlevendu = new ArticleVendu(noArticleEnCours, nomArticle, prixInitial, dateFinEncheres); 
					articlesvendus.add(articlevendu); 
					noArticlePrecedent = noArticleEnCours; 
				
				}
				int noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo"); 
				
				Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo);
				articlevendu.setUtilisateur(utilisateur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return articlesvendus;
	} 

	
}
