package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO{

	private final static String SELECT_ALL ="SELECT * FROM CATEGORIES;";
	private final static String INSERT_CATEGORIE = "INSERT INTO CATEGORIES(libelle)VALUES(?);";
	
	
	@Override
	public List<Categorie> selectAll(){
		List<Categorie> categories = new ArrayList<Categorie>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			int noCategoriePrecedent = 0;
			Categorie categorie = null;
			while (rs.next()) {
				int noCategorieEnCours = rs.getInt("no_categorie");

				if(noCategoriePrecedent != noCategorieEnCours) {
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
}

