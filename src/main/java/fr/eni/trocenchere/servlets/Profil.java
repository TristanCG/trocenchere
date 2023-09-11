package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.UtilisateurDAO;
import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noUtilisateur = 0;
		noUtilisateur = Integer.valueOf(request.getParameter("noUtilisateur"));
		System.out.println(noUtilisateur);
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
        Utilisateur utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur);
		request.setAttribute("utilisateur", utilisateur);
		
		if (utilisateur != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/profil.jsp");
		    rd.forward(request, response);
			System.out.println("ok servlet profil");
		} else {
			System.out.println("ko servlet profil");
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
