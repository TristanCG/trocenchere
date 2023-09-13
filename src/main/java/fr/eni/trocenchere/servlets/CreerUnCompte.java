package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import fr.eni.trocenchere.bll.UtilisateurManager;
import fr.eni.trocenchere.bo.Utilisateur;

public class CreerUnCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer noUtilisateurSession = (Integer) session.getAttribute("noUtilisateur");
		
		if(noUtilisateurSession != null) {
			int noUtilisateur = 0;
			noUtilisateur = Integer.valueOf(request.getParameter("noUtilisateur"));

			if(request.getParameter("delete") != null){
				UtilisateurManager.getInstance().delete(noUtilisateur);	
				RequestDispatcher rd = request.getRequestDispatcher("deconnexion");	
			    rd.forward(request, response);
			}
			
			if(request.getParameter("update") != null) {
				String action = "update";
		        request.setAttribute("action", action);
		        
				UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		        Utilisateur utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur);
				request.setAttribute("utilisateur", utilisateur);
				
	    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/creeruncompte.jsp");
	    		rd.forward(request, response);
			}
			
		} else {
			
			if(request.getParameter("noUtilisateur") == null) {
				String action = "insert";
	            request.setAttribute("action", action);
	    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/creeruncompte.jsp");
	    		rd.forward(request, response);
			}
		}	
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
		String confirmationmotDePasse = request.getParameter("confirmationMotDePasse");
		if ("insert".equals(action)) {
			
			if(motDePasse.equals(confirmationmotDePasse)) {
				
				try {
					UtilisateurManager.getInstance().insert(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false);
					response.sendRedirect("accueil"); 

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("Les mots de passe ne coresspondent pas");
			}
		}
		
		if (action.equals("update")) {
			System.out.println("Action = "+action);
			String motDePasseActuel = request.getParameter("motDePasseActuel");
			
			int noUtilisateur = 0;
			noUtilisateur = Integer.valueOf(request.getParameter("noUtilisateur"));

			UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	        Utilisateur utilisateur;
	        utilisateur = utilisateurManager.getUtilisateurByNo(noUtilisateur);
			request.setAttribute("utilisateur", utilisateur);
		    Integer noUtilisateurBDD = utilisateur.getNoUtilisateur();
		    
		    Boolean administrateurSession = false;
		    HttpSession session = request.getSession();
		    administrateurSession = (Boolean) session.getAttribute("administrateur");
		    System.out.println(administrateurSession);
			
		    if(noUtilisateurBDD == noUtilisateur || administrateurSession == true) {
		    	
				if(utilisateur != null) {
					
				    String motDePasseUserBDD = utilisateur.getMotDePasse();

				    System.out.println("Mot de passe actuelle= "+motDePasseActuel);
				    System.out.println("Mot de passe bdd = "+motDePasseUserBDD);
				    System.out.println("Mot de passe nouveau= "+motDePasse);
				    System.out.println("Mot de passe nouveau confirm = "+confirmationmotDePasse);
					if(motDePasseActuel.equals(motDePasseUserBDD)){ //|| administrateurSession == true) {
						
						try {
							utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
							UtilisateurManager.getInstance().updateUtilisateur(utilisateur);
							
							System.out.println("ok servlet creeUnCompte update");
							
							RequestDispatcher rd = request.getRequestDispatcher("profil");
					        rd.forward(request, response);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Try catch erreur servlet creeUnCompte update");
						}
						
					} else {
						System.out.println("Le mot de passe actuelle ne correspond pas servlet creeUnCompte update");
					}
				}
			}
		}
		
	}

}
