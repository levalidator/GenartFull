package com.genart.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Template;

public class DAOTemplate
{
	public static Template GetTemplateById(int idTemplate)
	{
    	Template template = null;
    	try
    	{	
    		ResultSet results = AccesBDD.getStatement().executeQuery("SELECT * FROM Template WHERE idTemplate = " + idTemplate);
    		results.first();

    		template = new Template(
					results.getInt("idTemplate"),
					results.getString("nameSketch"),
					results.getString("dateSketch"),
					results.getString("descriptionSketch"),
					results.getInt("IdArtist"),
					results.getInt("montant"),
					results.getString("created_at"),
					results.getString("imageTemplate"));
    	}
    	catch (Exception e)
    	{

    	}
	    return template;
	}
	
	public static List<Template> GetListTemplates()
	{
		List<Template> lesTemplates = null;

		try
		{
			ResultSet results;
			results = AccesBDD.getStatement().executeQuery("SELECT * FROM Template");			
			lesTemplates = new ArrayList<Template>();
			
			while (results.next())
			{
				Template template = new Template(
						results.getInt("idTemplate"),
						results.getString("nameSketch"),
						results.getString("dateSketch"),
						results.getString("descriptionSketch"),
						results.getInt("IdArtist"),
						results.getInt("montant"),
						results.getString("created_at"),
						results.getString("imageTemplate"));

				lesTemplates.add(template);
			}
		}
		catch(SQLException e)
		{
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return lesTemplates;		
	}

	public static List<Template> getTopTemplates(int limit)
	{
		List<Template> topTemplates = null;
		
		String query = "SELECT * FROM Template";
		query += limit == 0 ? "" : " LIMIT 0," + limit;
		
		try
		{
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			topTemplates = new ArrayList<Template>();
			
    		while (results.next())
    		{
				Template template = new Template(
						results.getInt("idTemplate"),
						results.getString("nameSketch"),
						results.getString("dateSketch"),
						results.getString("descriptionSketch"),
						results.getInt("IdArtist"),
						results.getInt("montant"),
						results.getString("created_at"),
						results.getString("imageTemplate"));
				
    			topTemplates.add(template);
    		}
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		
		return topTemplates;
	}
	
	public static List<Template> getTopTemplates(int idArtist, int limit)
	{
		List<Template> topTemplates = null;
		
		String query = "SELECT Template.* FROM Template INNER JOIN Artist ON Artist.IdArtist = " + idArtist;
		query += limit == 0 ? "" : " LIMIT 0," + limit;
		
		try
		{
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			topTemplates = new ArrayList<Template>();
			
    		while (results.next())
    		{
				Template template = new Template(
						results.getInt("idTemplate"),
						results.getString("nameSketch"),
						results.getString("dateSketch"),
						results.getString("descriptionSketch"),
						results.getInt("IdArtist"),
						results.getInt("montant"),
						results.getString("created_at"),
						results.getString("imageTemplate"));
				
    			topTemplates.add(template);
    		}
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		
		return topTemplates;
	}
}
