package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Artist;

public class DAOArtist
{
	public static List<Artist> getListArtist(int limit)
	{
		List<Artist> listArtists = null;
		
		String query = "SELECT * FROM Artist";
		query += limit == 0 ? "" :  "LIMIT 0," + limit;
		try
		{
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
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
	
	public static Artist GetArtistFromTemplate(int idTemplate)
	{
		Artist artist = null;
		
		try 
		{	
			ResultSet results = AccesBDD.getStatement().executeQuery("SELECT Artist.* FROM Artist INNER JOIN Template ON Template.idTemplate = " + idTemplate);
			results.first();

		 	 artist = new Artist(
		 			Integer.parseInt(results.getString("IdArtist")), 
		 			results.getString("mailArtist"), 
		 			results.getString("passwordArtist"), 
		 			results.getString("phoneArtist"), 
		 			results.getString("websiteArtist"), 
		 			results.getString("nameArtist"), 
		 			results.getString("firstNameArtist"), 
		 			results.getString("descriptionArtist"), 
		 			results.getString("pathAvatarArtist"));
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		return artist;
	}
	
	public static boolean InsertArtist(Artist artist){
		try{
			String query = "INSERT INTO Artist (mailArtist, passwordArtist, phoneArtist, websiteArtist, nameArtist, firstNameArtist, descriptionArtist, pathAvatarArtist) " +
					"VALUES ('"+artist.getMail()
					+"', '"+artist.getPassword()
					+"', '"+artist.getPhone()
					+"', '"+artist.getWebSite()
					+"', '"+artist.getName()
					+"', '"+artist.getFirstName()
					+"', '"+artist.getDescription()
					+"', '"+artist.getPathAvatar()+"')";
			
			AccesBDD.getStatement().execute(query);			
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}
