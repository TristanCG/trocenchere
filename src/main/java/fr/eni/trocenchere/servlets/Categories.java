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

import fr.eni.trocenchere.bll.CategorieManager;
import fr.eni.trocenchere.bo.Categorie;

public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session.getAttribute("noUtilisateur") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("accueil");
			rd.forward(request, response);
		} else {
			List<Categorie> categories = CategorieManager.getInstance().selectAll();
			request.setAttribute("categories", categories);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/categories.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
