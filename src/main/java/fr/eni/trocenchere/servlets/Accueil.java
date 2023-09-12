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
		System.out.println(categories);
		request.setAttribute("categories", categories);
		
		List<ArticleVendu> articlesvendus = ArticleVenduManager.getInstance().selectAll();
		System.out.println(articlesvendus);
		request.setAttribute("articlesvendus", articlesvendus);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = CategorieManager.getInstance().selectAll();
		System.out.println(categories);
		request.setAttribute("categories", categories);
		
		String nomRecherche = request.getParameter("nomRecherche");
		int categorieRecherche = Integer.valueOf(request.getParameter("categorieRecherche"));
		
		System.out.println("Nom recherché :"+nomRecherche);
		System.out.println("Catégorie recherché :"+categorieRecherche);
		
		List<ArticleVendu> articlesvendus=ArticleVenduManager.getInstance().selectNomCategorie(nomRecherche, categorieRecherche);
		request.setAttribute("articlesvendus", articlesvendus);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

}
