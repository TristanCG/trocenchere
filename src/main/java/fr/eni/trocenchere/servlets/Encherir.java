package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import fr.eni.trocenchere.bll.ArticleVenduManager;
import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bll.EnchereManager;
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
		
		
		
		HttpSession session = request.getSession();
		Integer noUtilisateurSession = (Integer) session.getAttribute("noUtilisateur");
		
		LocalDate dateDuJour = LocalDate.now();

		//Si on est connecté
		if(noUtilisateurSession != null) {
			//Si on est entre la date de début et la date de fin
			if((articleVendu.getDateDebutEncheres().isBefore(dateDuJour) || 
				articleVendu.getDateDebutEncheres().isEqual(dateDuJour)) && 
				(articleVendu.getDateFinEncheres().isAfter(dateDuJour) || 
				articleVendu.getDateFinEncheres().isEqual(dateDuJour))) {
				System.out.println("okkkkkkkkkkkkkkkkkkkkk");
				String condition = "ok";
		        request.setAttribute("condition", condition);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/encherir.jsp");
		rd.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate dateDuJour = LocalDate.now();
		int montantEnchere = 0;
		montantEnchere = Integer.valueOf(request.getParameter("proposition"));
		int noArticle = 0;
		noArticle = Integer.valueOf(request.getParameter("noArticle"));
		HttpSession session = request.getSession();
		Integer noUtilisateurSession = (Integer) session.getAttribute("noUtilisateur");
		
		EnchereManager.getInstance().insert(dateDuJour,montantEnchere,noArticle,noUtilisateurSession);
		RequestDispatcher rd = request.getRequestDispatcher("encherir?noArticle="+noArticle);
		rd.forward(request, response);
	}

}
