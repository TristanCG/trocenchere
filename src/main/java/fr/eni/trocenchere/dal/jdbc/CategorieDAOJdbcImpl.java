package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO{

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
}

