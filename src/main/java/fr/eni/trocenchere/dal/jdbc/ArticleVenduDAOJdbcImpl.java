package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
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

			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				nouveauArticleVendu.setNoArticle(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
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

					// Permet de convertir la donnée "Date" de la bdd en "Local Date"
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
	public List<ArticleVendu> selectNomCategorie(String nomRecherche, int categorieRecherche, String typeRecherche, String achats1, String achats2, String achats3, String ventes1, String ventes2, String ventes3, int noUtilisateurSession) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<ArticleVendu> articlesVenduParNomCategorie = new ArrayList<ArticleVendu>();
		String SELECT_NOM_CATEGORIE =  "SELECT ARTICLES_VENDUS.*, UTILISATEURS.no_utilisateur, UTILISATEURS.pseudo, CATEGORIES.no_categorie "
		        + "FROM ARTICLES_VENDUS "
		        + "JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur "
		        + "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
		        + "WHERE CATEGORIES.no_categorie = ?";

		
		 if (nomRecherche != null && !nomRecherche.isEmpty()) {
		        SELECT_NOM_CATEGORIE += " AND ARTICLES_VENDUS.nom_article LIKE ?";
		    }
		    
		    if (typeRecherche.equals("achats")) {
		        if (achats1 != null && !achats1.isEmpty()) {
		            SELECT_NOM_CATEGORIE += " AND ARTICLES_VENDUS.date_debut_encheres <= ? AND ? <= ARTICLES_VENDUS.date_fin_encheres";
		        }
		        if (achats2 != null && !achats2.isEmpty()) {
		            SELECT_NOM_CATEGORIE += " AND ARTICLES_VENDUS.no_utilisateur = ?";
		        }
		        if (achats3 != null && !achats3.isEmpty()) {
		            SELECT_NOM_CATEGORIE += " AND ? >= ARTICLES_VENDUS.date_fin_encheres";
		        }
		    }
		    
		    if (typeRecherche.equals("ventes")) {
		        SELECT_NOM_CATEGORIE += " AND ARTICLES_VENDUS.no_utilisateur = ?";
		        if (ventes1 != null && !ventes1.isEmpty()) {
		            SELECT_NOM_CATEGORIE += " AND ARTICLES_VENDUS.date_debut_encheres <= ? AND ? <= ARTICLES_VENDUS.date_fin_encheres";
		        }
		        if (ventes2 != null && !ventes2.isEmpty()) {
		            SELECT_NOM_CATEGORIE += " AND ARTICLES_VENDUS.date_debut_encheres > ?";
		        }
		        if (ventes3 != null && !ventes3.isEmpty()) {
		            SELECT_NOM_CATEGORIE += " AND ? > ARTICLES_VENDUS.date_fin_encheres";
		        }
		    }
		SELECT_NOM_CATEGORIE += ";";
		System.out.println(SELECT_NOM_CATEGORIE);
		LocalDate date = java.time.LocalDate.now();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			preparedStatement = cnx.prepareStatement(SELECT_NOM_CATEGORIE);
			int noParametre = 1 ;
			preparedStatement.setInt(noParametre, categorieRecherche);
			noParametre++;
			
			if (nomRecherche != null && !(nomRecherche.isEmpty())) {
				preparedStatement.setString(noParametre, "%"+nomRecherche+"%");
				noParametre++;
			}
			
			if(noUtilisateurSession != 0) {
				if(typeRecherche.equals("achats")) {
					// Enchère ouvertes
					if(achats1 != null && !(achats1.isEmpty())) {
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
					}
					
					// Mes enchères
					if(achats2 != null && !(achats2.isEmpty())) {
						preparedStatement.setInt(noParametre, noUtilisateurSession);
						noParametre++;
					}
					// Mes enchères remportés
					if(achats3 != null && !(achats3.isEmpty())) {
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
					}
				}
				
				//Ventes
				if(typeRecherche.equals("ventes")) {
					preparedStatement.setInt(noParametre, noUtilisateurSession);
					noParametre++;
					
					// Mes ventes en cours
					if(ventes1 != null && !(ventes1.isEmpty())) {
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
					}
					// Mes ventes non débutées
					if(ventes2 != null && !(ventes2.isEmpty())) {
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
					}
					// Ventes terminées
					if(ventes3 != null && !(ventes3.isEmpty())) {
						preparedStatement.setDate(noParametre, java.sql.Date.valueOf(date));
						noParametre++;
					}
				}
			}
			
			rs = preparedStatement.executeQuery();

			int noArticlePrecedent = 0;
			ArticleVendu articlevendu = null;
			while (rs.next()) {

				int noArticleEnCours = rs.getInt("no_article");
				if (noArticleEnCours != noArticlePrecedent) {
					String nomArticle = rs.getString("nom_article");
					int prixVente = rs.getInt("prix_vente");

					LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();

					articlevendu = new ArticleVendu(noArticleEnCours, nomArticle, prixVente, dateFinEncheres);
					articlesVenduParNomCategorie.add(articlevendu);
					noArticlePrecedent = noArticleEnCours;

				}
				int noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");

				Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo);
				articlevendu.setUtilisateur(utilisateur);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return articlesVenduParNomCategorie;
	}

	@Override
	public ArticleVendu encherir(int noArticle) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArticleVendu articleVendu = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {

			preparedStatement = cnx.prepareStatement("SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?");
			preparedStatement.setInt(1, noArticle);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int noArticle1 = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
				int prixInitial = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");
				int noUtilisateur = rs.getInt("no_utilisateur");
				int noCategorie = rs.getInt("no_categorie");
				articleVendu = new ArticleVendu(noArticle1, nomArticle, description, dateDebutEncheres, dateFinEncheres,
						prixInitial, prixVente, noUtilisateur, noCategorie);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleVendu;
	}

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) "
			+ "VALUES (?,?,?,?);";

	@Override
	public void insert(Retrait nouveauRetrait) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			// Insertion de le retrait
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_RETRAIT);
			pStmt.setInt(1, nouveauRetrait.getArticleVendu().getNoArticle());
			pStmt.setString(2, nouveauRetrait.getRue());
			pStmt.setString(3, nouveauRetrait.getCodePostal());
			pStmt.setString(4, nouveauRetrait.getVille());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
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
	
	private final static String DELETE_CATEGORIE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?;";
	@Override
	public void delete(int noArticleVendu) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_CATEGORIE);
			pStmt.setInt(1, noArticleVendu);
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}