package fr.eni.trocenchere.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ServletConnexionBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			
			//1. récupérer les infos du fichier context.xml
			Context context = new InitialContext();
			DataSource dataSource = 
					(DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			
			//2. récupérer la connexion à la BDD
			Connection cnx = dataSource.getConnection();
			
			out.println("La connexion est : " + 
							(cnx.isClosed() ? " fermée" : "ouverte"));
			
			//3. libère la connexion
			cnx.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
