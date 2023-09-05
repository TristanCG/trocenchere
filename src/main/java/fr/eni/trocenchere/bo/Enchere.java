package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class Enchere {

	private int noEnchere;
	private LocalDate dateEnchere;
	private int montantEnchere;
	private int noArticle;
	private int noUtilisateur;
	private Utilisateur utilisateurs; //Lien directionnel vers Utilisateur
	private ArticleVendu articlesvendus; //Lien directionnel vers Utilisateur
	
	//Constructeurs 
	public Enchere() {
		super();
	}

	//Getters et Setters 
	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Utilisateur getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Utilisateur utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public ArticleVendu getArticlesvendus() {
		return articlesvendus;
	}

	public void setArticlesvendus(ArticleVendu articlesvendus) {
		this.articlesvendus = articlesvendus;
	}

	//ToString 
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticle=" + noArticle + ", noUtilisateur=" + noUtilisateur + ", utilisateurs=" + utilisateurs
				+ ", articlesvendus=" + articlesvendus + "]";
	} 

	
}
