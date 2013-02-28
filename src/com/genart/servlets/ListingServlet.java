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

/**
 * Servlet implementation class SketchServlet
 */
@WebServlet("/listing")
public class ListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Template> templates = DAOTemplate.GetListTemplates();
		request.setAttribute("templates", templates);
		
		List<Artist> artistes = DAOArtist.getListArtist();
		Map<Integer, Artist> mapArtistes = new HashMap<Integer, Artist>();
		for (Artist artist : artistes) {
			mapArtistes.put(artist.getId(), artist);
		}
		request.setAttribute("artistes", mapArtistes);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/views/listing.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
