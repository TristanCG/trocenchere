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
import fr.eni.trocenchere.bo.Enchere;
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
		

		// On récupère la dernière enchère afin de l'afficher
		EnchereManager enchereManager = EnchereManager.getInstance(); 
		Enchere enchere = enchereManager.getEnchereByNo(noArticle);
		request.setAttribute("enchere", enchere);

		if (enchere != null) {
			// On récupère les infos de la personne avec la plus grande enchère
			int noUtilisateurEnchere = 0;
			noUtilisateurEnchere = enchere.getNoUtilisateur();
			UtilisateurManager utilisateurManager1 = UtilisateurManager.getInstance();
	        Utilisateur utilisateurEnchere = utilisateurManager1.getUtilisateurByNo(noUtilisateurEnchere);
			request.setAttribute("utilisateurEnchere", utilisateurEnchere); 
		} else {
			System.out.println("Il n'y as pas d'enchère");
		}
		
		
		
	
		
		
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
				System.out.println("Ok, on est bien situé entre les dates de fin et de début");
				String condition = "ok";
		        request.setAttribute("condition", condition);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/encherir.jsp");
		rd.forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    LocalDate dateDuJour = LocalDate.now();
	    int montantEnchere = Integer.valueOf(request.getParameter("proposition"));
	    int noArticle = Integer.valueOf(request.getParameter("noArticle"));
	    HttpSession session = request.getSession();
	    Integer noUtilisateurSession = (Integer) session.getAttribute("noUtilisateur");

	    // Permet de récupérer le paramètre du montant de "Ma Proposition"
	    ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();
	    ArticleVendu articleVendu = articleVenduManager.getArticleByNo(noArticle);
	    int montantActuel = articleVendu.getPrixVente();

	    //Condition si montant de l'utilisateur est bien supérieur au montant actuel (initial ou autres utilisateurs) 
	    if (montantEnchere > montantActuel) {
	        EnchereManager enchereManager = EnchereManager.getInstance();
	        Enchere nouvelleEnchere = enchereManager.insert(dateDuJour, montantEnchere, noArticle, noUtilisateurSession);
	        response.sendRedirect("encherir?noArticle=" + nouvelleEnchere.getNoArticle());
	    } else {
	        doGet(request, response);
	    }
	}

}
