package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.dal.EncherirDAO;

public class EncherirDAOJdbcImpl implements EncherirDAO {

	private final static String INSERT_ENCHERE = "INSERT INTO ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?);";
	@Override
	public void insert(Enchere nouvelleEnchere) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ENCHERE);
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
	}
	
	@Override
	public Enchere SelectEnchereByNo(int noEnchere) {
		PreparedStatement pStmt = null;
        ResultSet rs = null;
        Enchere enchere = null;
		try (Connection cnx = ConnectionProvider.getConnection()){
			pStmt = cnx.prepareStatement("SELECT * FROM ENCHERES WHERE no_enchere = ?");
			pStmt.setInt(1, noEnchere);
			rs = pStmt.executeQuery();
			if(rs.next()) {
				int noEnchere1 = rs.getInt("no_Enchere");
				LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
				int montantEnchere = rs.getInt("montant_enchere"); 
				int noArticle = rs.getInt("no_article");
				int noUtilisateur = rs.getInt("no_utilisateur"); 
				enchere = new Enchere(noEnchere1, dateEnchere, montantEnchere, noArticle, noUtilisateur);
			}
        } catch (Exception e) {
			e.printStackTrace();
        } 
        return enchere;
	}

}
