package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.UtilisateurDAO;
import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
		Utilisateur utilisateur = utilisateurDAO.connexionUtilisateur(email, motDePasse); 
		if (utilisateur != null) {
			HttpSession session = request.getSession();
			
	        session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
	        session.setAttribute("pseudo", utilisateur.getPseudo());
			session.setAttribute("nom", utilisateur.getNom());
	        session.setAttribute("prenom", utilisateur.getPrenom());
	        session.setAttribute("email", utilisateur.getEmail());
	        session.setAttribute("credit", utilisateur.getCredit());
	        session.setAttribute("administrateur", utilisateur.isAdministrateur());

	        System.out.println(session.getAttribute("email"));
	        
	        RequestDispatcher rd = request.getRequestDispatcher("accueil");
			rd.forward(request, response);
			
		} else {
			System.out.println("ko");
		}
	}
}
