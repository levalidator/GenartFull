package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Support;

public class DAOSupport {
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
}
