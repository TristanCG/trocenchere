package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private final static String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";


	@Override
	public void insert(Utilisateur nouveauUtilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			// Insertion de l'utilisateur
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_UTILISATEUR);
			pStmt.setString(1, nouveauUtilisateur.getPseudo());
			pStmt.setString(2, nouveauUtilisateur.getNom());
			pStmt.setString(3, nouveauUtilisateur.getPrenom());
			pStmt.setString(4, nouveauUtilisateur.getEmail());
			pStmt.setString(5, nouveauUtilisateur.getTelephone());
			pStmt.setString(6, nouveauUtilisateur.getRue());
			pStmt.setString(7, nouveauUtilisateur.getCodePostal());
			pStmt.setString(8, nouveauUtilisateur.getVille());
			pStmt.setString(9, nouveauUtilisateur.getMotDePasse());
			pStmt.setInt(10, 100);
			pStmt.setBoolean(11, false);
			
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
