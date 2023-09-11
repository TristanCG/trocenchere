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
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ArticleVenduDAO;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, "
			+ "date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?);";

	@Override
	public ArticleVendu insert(ArticleVendu nouveauArticleVendu) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Insertion de l'article
			
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nouveauArticleVendu.getNomArticle());
			pStmt.setString(2, nouveauArticleVendu.getDescription());
			pStmt.setDate(3, java.sql.Date.valueOf(nouveauArticleVendu.getDateDebutEncheres()));
			pStmt.setDate(4, java.sql.Date.valueOf(nouveauArticleVendu.getDateFinEncheres()));
			pStmt.setInt(5, nouveauArticleVendu.getPrixInitial());
			pStmt.setInt(6, nouveauArticleVendu.getPrixVente());
			pStmt.setInt(7, nouveauArticleVendu.getNoUtilisateur());
			pStmt.setInt(8, nouveauArticleVendu.getNoCategorie());
			
			System.out.println("Nouveau INSERT ARTICLE ArticleVenduDAOJDBC");
			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			
			if (rs.next()) {
				nouveauArticleVendu.setNoArticle(rs.getInt(1));
				System.out.println("coucou c'est rs.next clé");
			}
            
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("not work");
		}
		
		return nouveauArticleVendu;
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
			while (rs.next()) {

				int noArticleEnCours = rs.getInt("no_article");
				if (noArticleEnCours != noArticlePrecedent) {
					String nomArticle = rs.getString("nom_article");
					// TODO La c'est prix initial, il faudra le prix de vente actuel après
					int prixVente = rs.getInt("prix_vente");
					
					//	Permet de convertir la donnée "Date" de la bdd en "Local Date"
					LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();

					articlevendu = new ArticleVendu(noArticleEnCours, nomArticle, prixVente, dateFinEncheres);
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

	@Override
	public ArticleVendu encherir(int noArticle) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArticleVendu articleVendu = null;
		try (Connection cnx = ConnectionProvider.getConnection()){
			preparedStatement = cnx.prepareStatement("SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?");
			preparedStatement.setInt(1, noArticle);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				int noArticle1 = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
				int prixInitial = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");
				int noUtilisateur = rs.getInt("no_utilisateur");
				int noCategorie = rs.getInt("no_categorie");
				articleVendu = new ArticleVendu(noArticle1, nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, noUtilisateur, noCategorie);
				
				System.out.println("Ok ArticleVenduDAOJDBCImpl");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ko ArticleVenduDAOJDBCImpl");
		}
		return articleVendu;
	}
	
	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) "
			+ "VALUES (?,?,?,?);";

	@Override
	public void insert(Retrait nouveauRetrait) {
		System.out.println("Avant l'insertion d'un retrait");
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Insertion de le retrait
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_RETRAIT);
		    pStmt.setInt(1, nouveauRetrait.getArticleVendu().getNoArticle());
			pStmt.setString(2, nouveauRetrait.getRue());
			pStmt.setString(3, nouveauRetrait.getCodePostal());
			pStmt.setString(4, nouveauRetrait.getVille());

			System.out.println("Nouveau INSERT retrait ArticleVenduDAOJDBC");
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nouveau INSERT KO ArticleVenduDAOJDBC");
		}
		
	}
	
	@Override
	public Retrait selectRetraitByNoArticle(int noArticle) {
		PreparedStatement pStmt = null;
        ResultSet rs = null;
        Retrait retrait = null;
        try (Connection cnx = ConnectionProvider.getConnection()) {
        	pStmt = cnx.prepareStatement("SELECT * FROM RETRAITS WHERE no_article = ?;");
        	pStmt.setInt(1, noArticle);
        	rs = pStmt.executeQuery();
            if (rs.next()) {
                retrait = new Retrait();
                retrait.setNoArticle(rs.getInt("no_article"));
                retrait.setRue(rs.getString("rue")); 
                retrait.setCodePostal(rs.getString("code_postal"));
                retrait.setVille(rs.getString("ville"));
            }
        } catch (Exception e) {
			e.printStackTrace();
        } 
        return retrait;
	}
	
	
	
	
	
	
	
}
