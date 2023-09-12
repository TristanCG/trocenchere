package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	private static DataSource dataSource;

	static {
		try {
			// 1. récupérer les infos du fichier context.xml
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		// 2. récupérer la connexion à la BDD
		return dataSource.getConnection();
	}
}
