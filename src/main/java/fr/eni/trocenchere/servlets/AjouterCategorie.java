package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.print.attribute.standard.RequestingUserName;

import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class AjouterCategories
 */
public class AjouterCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("noCategorie") != null) {
			int noCategorie = 0;
			noCategorie = Integer.valueOf(request.getParameter("noCategorie"));
			System.out.println(noCategorie);

			CategorieManager categorieManager = CategorieManager.getInstance();
			Categorie categorie = categorieManager.getCategorieByNo(noCategorie);
			request.setAttribute("categorie", categorie);
		
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ajouter_categorie.jsp");
	    rd.forward(request, response);
		System.out.println("ok servlet Ajout Categorie");
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String libelle = request.getParameter("libelle");
		if(request.getParameter("noCategorie") != null) {
			int noCategorie = 0;
			noCategorie = Integer.valueOf(request.getParameter("noCategorie"));
			System.out.println(noCategorie);
			//TODO update Categorie
		
		}
		
		if(request.getParameter("noCategorie") == null) {
			try { 
				CategorieManager.getInstance().insert(libelle);
				RequestDispatcher rd = request.getRequestDispatcher("categories");
		        rd.forward(request, response);
		   
			} catch (Exception e) {
				
			}
		}
		
		
		
	}

}
