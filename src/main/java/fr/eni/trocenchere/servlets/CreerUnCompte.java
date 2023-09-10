package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Utilisateur;

public class CreerUnCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("noUtilisateur") != null) {
			String action = "update";
            request.setAttribute("action", action);
            
			int noUtilisateur = 0;
			noUtilisateur = Integer.valueOf(request.getParameter("noUtilisateur"));
			
			UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	        Utilisateur utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur);
			request.setAttribute("utilisateur", utilisateur);
		}
		if(request.getParameter("noUtilisateur") == null) {
			String action = "insert";
            request.setAttribute("action", action);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/creeruncompte.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		if (action.equals("insert")) {
			try {
				UtilisateurManager.getInstance().insert(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (action.equals("update")) {
			try {
				int noUtilisateur = 0;
				noUtilisateur = Integer.valueOf(request.getParameter("noUtilisateur"));
				
				Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
				UtilisateurManager.getInstance().updateUtilisateur(utilisateur);
				
				System.out.println("ok serlvet update utilisateur post");
				
				RequestDispatcher rd = request.getRequestDispatcher("profil");
		        rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
