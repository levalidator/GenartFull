package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Artist;

public class DAOArtist
{
	public static List<Artist> getListArtist()
	{
		List<Artist> listArtists = null;
		
		try 
		{	
			ResultSet results = AccesBDD.getStatement().executeQuery("SELECT * FROM Artist LIMIT 0,5");
			listArtists = new ArrayList<Artist>();
			
    		while (results.next())
    		{
    		 	Artist artist = new Artist(
    		 			Integer.parseInt(results.getString("IdArtist")), 
    		 			results.getString("mailArtist"), 
    		 			results.getString("passwordArtist"), 
    		 			results.getString("phoneArtist"), 
    		 			results.getString("websiteArtist"), 
    		 			results.getString("nameArtist"), 
    		 			results.getString("firstNameArtist"), 
    		 			results.getString("descriptionArtist"), 
    		 			results.getString("pathAvatarArtist"));
    		 	
    		 	listArtists.add(artist);
    		}
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		return listArtists;
	}
}
