package fr.eni.trocenchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.trocenchere.bll.ArticleVenduManager;
import fr.eni.trocenchere.bo.ArticleVendu;

public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noArticle = 0;
		noArticle = Integer.valueOf(request.getParameter("noArticle"));
		
		System.out.println(noArticle);
		
		ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();
		ArticleVendu articleVendu = articleVenduManager.getArticleByNo(noArticle);
		request.setAttribute("articleVendu", articleVendu);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/encherir.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
