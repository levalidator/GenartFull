package com.genart.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ArtistDetails
 */
@WebServlet("/artistDetails")
public class ArtistDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("id");
		
		if (value == null || value.isEmpty())
		{
			response.sendRedirect("artists");
		}
		else
		{
			int id = -1;
			try
			{
				id = Integer.parseInt(value);
			}
			catch (NumberFormatException numberFormatEx)
			{
				response.sendRedirect("artists");
			}
			
			Artist artist = DAOArtist.GetArtist(id);
			
			if (artist != null)
			{
				request.setAttribute("artist", artist);	
				
				List<Template> templates = DAOTemplate.getTopTemplates(id, 0);
				
				request.setAttribute("templates", templates);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/artistDetail.jsp").forward(request, response);
			}
			else
			{
				//Unknown artist
				this.getServletContext().getRequestDispatcher("/WEB-INF/static/404.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
