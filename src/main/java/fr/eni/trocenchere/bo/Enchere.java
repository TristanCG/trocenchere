package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class Enchere {

	private int noEnchere;
	private LocalDate dateEnchere;
	private int montantEnchere;
	private int noArticle;
	private int noUtilisateur;
	
	//Constructeurs 
	public Enchere() {
		super();
	}

	public Enchere(int noEnchere) {
		this();
		this.noEnchere = noEnchere;
	}


	public Enchere(LocalDate dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
		this();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = noUtilisateur;
	}



	public Enchere(int noEnchere2, LocalDate dateEnchere2, int montantEnchere2, int noArticle1, int noUtilisateur2) {
		this();
		this.noEnchere = noEnchere2; 
		this.dateEnchere = dateEnchere2;
		this.montantEnchere = montantEnchere2;
		this.noArticle = noArticle1;
		this.noUtilisateur = noUtilisateur2;
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
	
	//ToString 
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticle=" + noArticle + ", noUtilisateur=" + noUtilisateur + "]";
	} 

	
}
