package fr.eni.trocenchere.bll;

import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAOFactory;
import fr.eni.trocenchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	//Singleton
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	private UtilisateurManager() {
		
	}
	//Fin Singleton
	
	public Utilisateur insert(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		Utilisateur nouveauUtilisateur = new Utilisateur (pseudo, nom, prenom, email, telephone, rue , codePostal, ville, motDePasse, credit, administrateur);
		
		System.out.println(nouveauUtilisateur);
		
		DAOFactory.getUtilisateurDAO().insert(nouveauUtilisateur);
		
		return nouveauUtilisateur;
		
	}

	public Utilisateur getUtilisateurByNo(int noUtilisateur) {
	    UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	    return utilisateurDAO.profilUtilisateur(noUtilisateur);
	}
}
