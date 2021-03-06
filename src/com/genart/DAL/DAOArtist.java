package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Artist;

/**
 * DAO for Artist class
 * @author The GenArt Team
 *
 */
public class DAOArtist
{
	/**
	 * Returns the artists list 
	 */
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
	
	/**
	 * Get an Artist for a template id 
	 */
	public static Artist GetArtistFromTemplate(int idTemplate)
	{
		Artist artist = null;
		
		try 
		{	
			ResultSet results = AccesBDD.getStatement().executeQuery("SELECT Artist.* FROM Artist LEFT JOIN Template ON Template.IdArtist = Artist.IdArtist WHERE Template.IdTemplate = " + idTemplate);
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
	
	/**
	 * Insert an Artist in database
	 */
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
	
	/**
	 * Get an Artist by his mail 
	 */
	public static Artist GetArtistByMail(String mail){
		try 
		{	
			String query = "select * from Artist where mailArtist = '"+mail+"'";
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			boolean exists = results.first();
			Artist artist;
			if (exists){
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
			} else {
				artist = null;
			}
			return artist;
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    		return null;
    	}
	}
	
	/**
	 * Get the max Id in the Artist table 
	 */
	public static int GetNextId(){
		try 
		{	
			String query = "select max(idArtist) as max from Artist";
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
	 * Get an Artist by his id 
	 */
	public static Artist GetArtist(int id) {
		try 
		{	
			String query = "Select * From Artist Where IdArtist = "+id;
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			boolean exists = results.first();
			Artist artist;
			if (exists){
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
			} else {
				artist = null;
			}
			return artist;
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    		return null;
    	}
	}
	
	/**
	 * Update an Artist in database 
	 */
	public static boolean UpdateArtist(Artist artist)
	{
		try{
			String query = "UPDATE Artist SET " 
						   + "mailArtist = '"+artist.getMail()+"', "
						   + "passwordArtist = '"+artist.getPassword()+"', "
						   + "phoneArtist = '"+artist.getPhone()+"', "
						   + "websiteArtist = '"+artist.getWebSite()+"', "
						   + "nameArtist = '"+artist.getName()+"', "
						   + "firstNameArtist = '"+artist.getFirstName()+"', "
						   + "descriptionArtist = '"+artist.getDescription()+"', "
						   + "pathAvatarArtist = '"+artist.getPathAvatar()+"' "
						   + "WHERE idArtist = '"+ artist.getId() +"'";
			
			AccesBDD.getStatement().execute(query);			
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Delete an artist 
	 */
	public static boolean DeleteArtist(int idArtist)
	{
		try {
			
			String query = "DELETE from Artist where idArtist = '"+ idArtist +"'";
			AccesBDD.getStatement().execute(query);			
			
			return true;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
}
