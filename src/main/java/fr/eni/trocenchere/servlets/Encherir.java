package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.trocenchere.bll.ArticleVenduManager;
import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;

public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On va cehrcher les infos de la table Article selon son numéro via le GET
		int noArticle = 0;
		noArticle = Integer.valueOf(request.getParameter("noArticle"));
		ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();
		ArticleVendu articleVendu = articleVenduManager.getArticleByNo(noArticle);
		request.setAttribute("articleVendu", articleVendu);
		
		Retrait retrait = articleVenduManager.getRetraitByNo(noArticle);
		request.setAttribute("retrait", retrait);
		
		//On va chercher les infos de la table Catégorie selon son numéro
		int noCategorie = 0;
		noCategorie = articleVendu.getNoCategorie();
		CategorieManager categorieManager = CategorieManager.getInstance();
		Categorie categorie = categorieManager.getCategorieByNo(noCategorie);
		request.setAttribute("categorie", categorie);
		
		//On va chercher les infos de la table Utilisateur selon son numéro
		int noUtilisateur = 0;
		noUtilisateur = articleVendu.getNoUtilisateur();
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
        Utilisateur utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur);
		request.setAttribute("utilisateur", utilisateur);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/encherir.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
