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
			_connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/genart", "root", "root");
		}
		return _connexion.createStatement();
	}
	
	public static void closeConnection() throws SQLException
	{
		_connexion.close();
	}
}
