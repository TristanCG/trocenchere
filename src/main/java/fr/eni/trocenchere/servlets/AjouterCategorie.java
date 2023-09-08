package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bo.Categorie;

public class AjouterCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("supprimer") != null) {
			String supprimeNoCategorie = request.getParameter("supprimer");
			int noCategorie = Integer.parseInt(supprimeNoCategorie);
			CategorieManager.getInstance().delete(noCategorie);	
			RequestDispatcher rd = request.getRequestDispatcher("categories");	
		    rd.forward(request, response);
		}
		
		if(request.getParameter("noCategorie") != null) {
			int noCategorie = 0;
			noCategorie = Integer.valueOf(request.getParameter("noCategorie"));

			CategorieManager categorieManager = CategorieManager.getInstance();
			Categorie categorie = categorieManager.getCategorieByNo(noCategorie);
			request.setAttribute("categorie", categorie);
			
			String action = "update";
            request.setAttribute("action", action);
    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ajouter_categorie.jsp");
    	    rd.forward(request, response);
		}
		
		if(request.getParameter("noCategorie") == null) {
            String action = "insert";
            request.setAttribute("action", action);
    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ajouter_categorie.jsp");
    	    rd.forward(request, response);
        }
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        String libelle = request.getParameter("libelle");
        
        if (action.equals("insert")) {
			try { 
				CategorieManager.getInstance().insert(libelle);
				RequestDispatcher rd = request.getRequestDispatcher("categories");
		        rd.forward(request, response);
			} catch (Exception e) {
				System.out.println("KO POST");
			}
        } 
        if (action.equals("update")){
			int noCategorie = 0;
			noCategorie = Integer.valueOf(request.getParameter("noCategorie"));

			Categorie categorie = new Categorie (noCategorie, libelle); 
			CategorieManager.getInstance().updateCategorie(categorie);

			RequestDispatcher rd = request.getRequestDispatcher("categories");
	        rd.forward(request, response);
			
        }
		
		
	}

}
