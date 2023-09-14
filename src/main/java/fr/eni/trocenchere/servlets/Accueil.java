package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import fr.eni.trocenchere.bll.ArticleVenduManager;
import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;

public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Categorie> categories = CategorieManager.getInstance().selectAll();
		request.setAttribute("categories", categories);
		
		List<ArticleVendu> articlesvendus = ArticleVenduManager.getInstance().selectAll();
		request.setAttribute("articlesvendus", articlesvendus);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = CategorieManager.getInstance().selectAll();
		request.setAttribute("categories", categories);
		
		String nomRecherche = request.getParameter("nomRecherche");
		int categorieRecherche = Integer.valueOf(request.getParameter("categorieRecherche"));
		String typeRecherche = request.getParameter("typeRecherche");
		String achats1 = request.getParameter("achats1");
		String achats2 = request.getParameter("achats2");
		String achats3 = request.getParameter("achats3");
		String ventes1 = request.getParameter("ventes1");
		String ventes2 = request.getParameter("ventes2");
		String ventes3 = request.getParameter("ventes3");
		
		if (typeRecherche == null) {
			typeRecherche = "achats";
		}
		
		HttpSession session = request.getSession(false);
		Integer noUtilisateurSession = null; 
		
		if (session != null) {
		    noUtilisateurSession = (Integer) session.getAttribute("noUtilisateur");

		    if (noUtilisateurSession != null) {
		        int noUtilisateur = noUtilisateurSession.intValue();
		        System.out.println("Session trouvée, noUtilisateur = " + noUtilisateur);
		    } else {
		    	noUtilisateurSession = 0;
		    }
		} else {
	    	noUtilisateurSession = 0;
		}
		
		List<ArticleVendu> articlesvendus=ArticleVenduManager.getInstance().selectNomCategorie(nomRecherche, categorieRecherche, typeRecherche, achats1, achats2, achats3, ventes1, ventes2, ventes3, noUtilisateurSession);
		request.setAttribute("articlesvendus", articlesvendus);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

}
