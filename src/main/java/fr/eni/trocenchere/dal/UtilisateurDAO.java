package fr.eni.trocenchere.dal;

import fr.eni.trocenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	void insert(Utilisateur nouveauUtilisateur);

	Utilisateur connexionUtilisateur(String email, String motDePasse);
}
