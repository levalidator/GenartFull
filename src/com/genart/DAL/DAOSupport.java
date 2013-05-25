package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Support;
/**
 * DAO for Artist class
 * @author The GenArt Team
 *
 */
public class DAOSupport {
	/**
	 * Returns the supports list 
	 */
	public static List<Support> GetListSupport()
	{
		List<Support> listSupports = null;
		
		try 
		{
			ResultSet results = AccesBDD.getStatement().executeQuery("SELECT * FROM Support");
			listSupports = new ArrayList<Support>();
			
    		while (results.next())
    		{
    			Support support = new Support(
    					results.getInt("idSupport"), 
    					results.getFloat("dimention_x"),
    					results.getFloat("dimention_y"),
    					results.getFloat("dimention_z"),
    					results.getString("name"), 
    					results.getString("description"),
    					results.getFloat("montant"));
    		 	
    			listSupports.add(support);
    		}
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		return listSupports;
	}
	
	/**
	 * Get the max idSupport in the Support table 
	 */
	public static int GetNextId(){
		try 
		{	
			String query = "select max(idSupport) as max from Support";
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			boolean exists = results.first();
			int maxId; 
			if (exists){
				maxId = Integer.parseInt(results.getString("max")) + 1;
			} else {
				maxId = 0;
			}
			return maxId;
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    		return 0;
    	}
	}
	
	/**
	 * Insert a support 
	 */
	public static boolean InsertSupport(Support support){
		try 
		{	
			String query = "INSERT INTO Support (dimention_x, dimention_y, dimention_z, name, description, montant) " +
					"VALUES ('"+support.getDimensionX()
					+"', '"+support.getDimensionY()
					+"', '"+support.getDimensionZ()
					+"', '"+support.getName()
					+"', '"+support.getDescription()
					+"', '"+support.getMontant()+"')";
			
			AccesBDD.getStatement().execute(query);			
			return true;
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    		return false;
    	}
	}
	
	/**
	 * Delete a support 
	 */
	public static boolean DeleteSupport(int idSupport)
	{
		try {
			
			String query = "DELETE from Support where idSupport = '"+ idSupport +"'";
			AccesBDD.getStatement().execute(query);			
			
			return true;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Update a support 
	 */
	public static boolean UpdateSupport(Support support)
	{
		try{
			String query = "UPDATE Support SET " 
						   + "dimention_x = '"+support.getDimensionX()+"', "
						   + "dimention_y = '"+support.getDimensionY()+"', "
						   + "dimention_z = '"+support.getDimensionZ()+"', "
						   + "description = '"+support.getDescription()+"', "
						   + "name = '"+support.getName()+"', "
						   + "montant = '"+support.getMontant()+"' "
						   + "WHERE idSupport = '"+ support.getId() +"'";
			
			AccesBDD.getStatement().execute(query);			
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}
