package com.genart.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOArtist;
import com.genart.DAL.DAOSupport;
import com.genart.DAL.DAOTemplate;
import com.genart.beans.Artist;
import com.genart.beans.Support;
import com.genart.beans.Template;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idTemplate = Integer.parseInt(request.getParameter("id"));
		
		Template template = DAOTemplate.GetTemplateById(idTemplate);
		Artist artist = DAOArtist.GetArtistFromTemplate(idTemplate);
		List<Template> templates = DAOTemplate.getTopTemplates(template.getIdArtist(), 3);
		List<Support> supports = DAOSupport.GetListSupport();

		request.setAttribute("template", template);
		request.setAttribute("templates", templates);
		request.setAttribute("supports", supports);
		request.setAttribute("artist", artist);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
