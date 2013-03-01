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
<<<<<<< HEAD
			_connexion = DriverManager.getConnection("jdbc:mysql://10.50.125.55/genart", "root", "unzziped");
=======
			_connexion = DriverManager.getConnection("jdbc:mysql://localhost/genart", "root", "unzziped");
>>>>>>> bd0fe55014509d25709751ab9cc1c0d40c643ab1
		}
		return _connexion.createStatement();
	}
	
	public static void closeConnection() throws SQLException
	{
		_connexion.close();
	}
}
