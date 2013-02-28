package com.genart.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOArtist;
import com.genart.DAL.DAOTemplate;
import com.genart.beans.Artist;
import com.genart.beans.Template;


@SuppressWarnings("serial")
@WebServlet("")
public class IndexServlet extends HttpServlet
{
	public static final String TOP_TEMPLATES = "topTemplates";
	public static final String LST_ARTISTS = "listArtists";
	public static final String MAP_ARTISTS = "mapArtists";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Template> topTemplates = DAOTemplate.getTopTemplates(3);
		List<Artist> listArtists = DAOArtist.getListArtist(0);
		
		Map<Integer, Artist> mapArtist = new HashMap<Integer, Artist>();
		for(Artist artist : listArtists){
			mapArtist.put(artist.getId(), artist);
		}
		
        request.setAttribute(MAP_ARTISTS, mapArtist);
        request.setAttribute(TOP_TEMPLATES, topTemplates);
        request.setAttribute(LST_ARTISTS, listArtists);
        
	    this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
