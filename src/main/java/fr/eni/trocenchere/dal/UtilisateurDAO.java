package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	void insert(Utilisateur nouveauUtilisateur);

	Utilisateur connexionUtilisateur(String email, String motDePasse);

	Utilisateur profilUtilisateur(int noUtilisateur);

	void updateUtilisateur(Utilisateur utilisateur);

	void delete(int noUtilisateur);

}
