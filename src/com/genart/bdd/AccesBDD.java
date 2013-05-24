package com.genart.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesBDD
{
 	private static Connection _connexion;
	
 	/**
 	 * Start a connection if no one exists and create a statement object for sending SQL statements to the database
 	 * @return the statement if the class cannot be located
 	 * @throws SQLException if a database access error occurs       
 	 * @throws ClassNotFoundException
 	 */ 
	public static Statement getStatement() throws SQLException, ClassNotFoundException
	{
		if(_connexion == null || _connexion.isClosed())
		{
			Class.forName("com.mysql.jdbc.Driver");
			//_connexion = DriverManager.getConnection("jdbc:mysql://prozonline.no-ip.org/genart", "genart", "Jeq7gjk");
			//_connexion = DriverManager.getConnection("jdbc:mysql://localhost/genart", "root", "unzziped");
			//_connexion = DriverManager.getConnection("jdbc:mysql://10.50.125.55/genart", "root", "unzziped");
			//_connexion = DriverManager.getConnection("jdbc:mysql://localhost/genart", "root", "admin");
			_connexion = DriverManager.getConnection("jdbc:mysql://10.50.126.95/genart", "xavier", "xavier");
		}
		return _connexion.createStatement();
	}
	
	/**
	 * Releases the connection object immediately
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException
	{
		_connexion.close();
	}
}
