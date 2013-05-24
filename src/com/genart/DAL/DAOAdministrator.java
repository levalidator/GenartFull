package com.genart.DAL;

import java.sql.ResultSet;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Administrator;

/**
 * DAO for Administrator class
 * @author The GenArt Team
 *
 */
public class DAOAdministrator {
	
	/**
	 * Get an Administrator by his mail 
	 */
	public static Administrator GetAdministratorByMail(String mail){
		try 
		{	
			String query = "select * from Administrator where mailAdministrator = '"+mail+"'";
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			boolean exists = results.first();
			Administrator admin;
			if (exists){
				admin = new Administrator(Integer.parseInt(results.getString("idAdministrator")), 
						results.getString("idAdministrator"), 
						results.getString("passwordAdministrator"));
			} else {
				admin = null;
			} 
			return admin;
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    		return null;
    	}
	}
}
