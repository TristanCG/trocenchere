package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

import fr.eni.trocenchere.bll.ArticleVenduManager;

public class Vendre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/vendre.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prixInitial = 0; 
		//1. On récupère les paramètres du formulaire
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String dateDebutEncheres = request.getParameter("dateDebutEncheres");
		System.out.println(dateDebutEncheres);
		String dateFinEncheres = request.getParameter("dateFinEncheres");
		System.out.println(dateFinEncheres);
		prixInitial = Integer.valueOf(request.getParameter("prixInitial"));
		System.out.println(prixInitial);
		
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
		
		try {
			ArticleVenduManager.getInstance().insert(nomArticle, description, dateDebut, dateFin, prixInitial);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur insertion date");
		}
		//doGet(request, response);
	}

}
