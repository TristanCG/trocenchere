package fr.eni.trocenchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private int noCategorie;
	private String libelle;
	private List <ArticleVendu> articles = new ArrayList <ArticleVendu>(); //Liste d'articles vendus 
	
	//Constructeurs 
	public Categorie() {
		super();
	}


	//Getters et Setters 
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
	
	public List <ArticleVendu> getArticles() {
		return articles;
	}

	public void setArticles(List <ArticleVendu> articles) {
		this.articles = articles;
	}

	
	//ToString 
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", articles=" + articles + "]";
	} 
		
	
}
