package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	
	@Override
	public Utilisateur connexionUtilisateur(String email, String motDePasse) {
		final String SELECT_CONNEXION = "SELECT no_utilisateur, pseudo, nom, prenom, email, mot_de_passe, credit, administrateur "
				+ "FROM UTILISATEURS WHERE (email=? OR pseudo = ?)AND mot_de_passe=?";
		
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try (Connection cnx = ConnectionProvider.getConnection()) {
            preparedStatement = cnx.prepareStatement(SELECT_CONNEXION);
            preparedStatement.setString(1, email);
            //TODO email pseudo
            preparedStatement.setString(2, motDePasse);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setNoUtilisateur(resultSet.getInt("no_utilisateur"));
                utilisateur.setPseudo(resultSet.getString("pseudo"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setMotDePasse(resultSet.getString("mot_de_passe"));
                utilisateur.setCredit(resultSet.getInt("credit"));
                utilisateur.setAdministrateur(resultSet.getBoolean("administrateur"));
            }
        } catch (Exception e) {
			e.printStackTrace();
        } 

        return utilisateur;
    }
	

	@Override
	public void insert(Utilisateur nouveauUtilisateur) {
		final String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

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
