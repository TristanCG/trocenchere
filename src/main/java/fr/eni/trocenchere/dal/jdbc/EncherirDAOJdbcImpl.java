package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.dal.EncherirDAO;

public class EncherirDAOJdbcImpl implements EncherirDAO {

	private final static String INSERT_ENCEHRE = "ISNERT INTO ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?);";
	@Override
	public Enchere insert(Enchere nouvelleEnchere) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ENCEHRE);
			pStmt.setDate(1, java.sql.Date.valueOf(nouvelleEnchere.getDateEnchere()));
			pStmt.setInt(2, nouvelleEnchere.getMontantEnchere());
			pStmt.setInt(3, nouvelleEnchere.getNoArticle());
			pStmt.setInt(4, nouvelleEnchere.getNoUtilisateur());
			
			System.out.println("Nouveau INSERT ENCHERE EnchereDAOJDBC");
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("KO Nouveau INSERT ENCHERE EnchereDAOJDBC");
		}
		return null;
	}

}
