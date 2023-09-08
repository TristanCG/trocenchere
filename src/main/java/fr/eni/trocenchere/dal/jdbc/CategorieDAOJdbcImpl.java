package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private final static String SELECT_ALL = "SELECT * FROM CATEGORIES;";

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> categories = new ArrayList<Categorie>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);

			int noCategoriePrecedent = 0;
			Categorie categorie = null;
			while (rs.next()) {
				int noCategorieEnCours = rs.getInt("no_categorie");

				if (noCategoriePrecedent != noCategorieEnCours) {
					String libelle = rs.getString("libelle");
					categorie = new Categorie(noCategorieEnCours, libelle);
					categories.add(categorie);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	private final static String INSERT_CATEGORIE = "INSERT INTO CATEGORIES(libelle)VALUES(?);";

	@Override
	public void insert(Categorie nouvelleCategorie) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_CATEGORIE);

			pStmt.setString(1, nouvelleCategorie.getLibelle());
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Categorie selectCategorieById(int noCategorie) {
		ResultSet resultSet = null;
		Categorie categorie = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement("SELECT * FROM CATEGORIES WHERE no_categorie = ?;");
			pStmt.setInt(1, noCategorie);
			resultSet = pStmt.executeQuery();
			if (resultSet.next()) {
				categorie = new Categorie();
				categorie.setNoCategorie(resultSet.getInt("no_Categorie"));
				categorie.setLibelle(resultSet.getString("libelle"));
				System.out.println("ok categorieSelectById DAOJDBCImpl");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ko categorieSelectById DAOJDBCImpl");
		}
		return categorie;
	}

	
	private final static String UPDATE_CATEGORIE = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?;";

	@Override
	public void updateCategorie(Categorie categorie) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_CATEGORIE);
			pStmt.setString(1, categorie.getLibelle());
			pStmt.setInt(2, categorie.getNoCategorie());

			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private final static String DELETE_CATEGORIE = "DELETE FROM CATEGORIES WHERE no_categorie = ?;";
	@Override
	public void delete(int noCategorie) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_CATEGORIE);
			pStmt.setInt(1, noCategorie);
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
