package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.print.attribute.standard.RequestingUserName;

import fr.eni.trocenchere.bll.CategorieManger;

/**
 * Servlet implementation class AjouterCategories
 */
public class AjouterCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ajouter_categorie.jsp");
	        rd.forward(request, response);
	    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String libelle = request.getParameter("libelle");
		
		try { 
			CategorieManger.getInstance().insert(libelle);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/categories.jsp");
	        rd.forward(request, response);
	    
			
			
		} catch (Exception e) {
			
		}
		
	}

}
