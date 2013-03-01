package com.genart.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesBDD
{
 	private static Connection _connexion;
	
	public static Statement getStatement() throws SQLException, ClassNotFoundException
	{
		if(_connexion == null || _connexion.isClosed())
		{
			Class.forName("com.mysql.jdbc.Driver");
			//_connexion = DriverManager.getConnection("jdbc:mysql://prozonline.no-ip.org/genart", "genart", "Jeq7gjk");
			_connexion = DriverManager.getConnection("jdbc:mysql://localhost/genart", "root", "unzziped");
		}
		return _connexion.createStatement();
	}
	
	public static void closeConnection() throws SQLException
	{
		_connexion.close();
	}
}
