package fr.eni.trocenchere.bo;

public class Categorie {

	private int noCategorie;
	private String libelle;

	// Getters et Setters
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	// ToString
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

	// Constructeurs
	public Categorie() {
		super();
	}

	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
}
