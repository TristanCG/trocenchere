package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.bll.ArticleVenduManager;
import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;

public class Vendre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = CategorieManager.getInstance().selectAll();
		System.out.println(categories);
		request.setAttribute("categories", categories);

		HttpSession session = request.getSession(); 
		int noUtilisateur = (int) session.getAttribute("noUtilisateur"); 
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
        Utilisateur utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur);
		request.setAttribute("utilisateur", utilisateur);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/vendre.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prixInitial = 0;  
		int noCategorie = 0; 

		//1. On récupère les paramètres du formulaire pour l'article 
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String dateDebutEncheres = request.getParameter("dateDebutEncheres");
		System.out.println(dateDebutEncheres);
		String dateFinEncheres = request.getParameter("dateFinEncheres");
		System.out.println(dateFinEncheres);
		prixInitial = Integer.valueOf(request.getParameter("prixInitial"));
		System.out.println(prixInitial);
		int prixVente = prixInitial; 
		
		HttpSession session = request.getSession();
		
		Integer noUtilisateur = (Integer) session.getAttribute("noUtilisateur");

		System.out.println(noUtilisateur);
		
		String categorie = request.getParameter("categorie");
		if (categorie != null) {
		    // Convertir la valeur en integer
		   noCategorie = Integer.parseInt(categorie);
		   
		} else {
			//TODO a faire en cas de catégorie null
		}
		   System.out.println(noCategorie);

		//2. On transforme les dates pour le bon type 
		LocalDate dateDebut = null;
		try {
			dateDebut = LocalDate.parse(dateDebutEncheres);
		} catch (DateTimeException e) {
			e.printStackTrace();
			System.out.println("Erreur date début enchère");
		}
		
		LocalDate dateFin = null;
		try {
			dateFin = LocalDate.parse(dateFinEncheres);
		} catch (DateTimeException e) {
			e.printStackTrace();
			System.out.println("Erreur date fin enchère");

		}
		ArticleVendu article = null;
		try {
		   article = ArticleVenduManager.getInstance().insert(nomArticle, description, dateDebut, dateFin, prixInitial, prixInitial, noUtilisateur, noCategorie);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(article);
		HttpSession session1 = request.getSession(); 
		int noUtilisateur1 = (int) session1.getAttribute("noUtilisateur"); 
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
        Utilisateur utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur1);
		request.setAttribute("utilisateur", utilisateur);
		
		System.out.println(utilisateur.getEmail());
		
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		if(!(request.getParameter("rue").equalsIgnoreCase(utilisateur.getRue())) || 
			!(request.getParameter("codePostal").equalsIgnoreCase(utilisateur.getCodePostal())) || 
			!(request.getParameter("ville").equalsIgnoreCase(utilisateur.getVille())) ) {
			
			System.out.println("condition ok");
			try {
				ArticleVenduManager.getInstance().insert(article, rue, codePostal, ville);
				System.out.println("Try ok");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("erreur récupération données formulaire");
			}
		}
		response.sendRedirect("accueil");
		
		//doGet(request, response);
	}

}
