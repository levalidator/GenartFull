package com.genart.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOArtist;
import com.genart.bdd.AccesBDD;
import com.genart.beans.Artist;

@SuppressWarnings("serial")
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	public ConnexionServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mode = request.getParameter("mode");
		String object = request.getParameter("object");
    	
    	if (mode.equals("insert")){
    		if (object.equals("artist")){
    			String name = request.getParameter("nameArtist");
    			String fname = request.getParameter("firstnameArtist");
    			String mail = request.getParameter("mailArtist");
    			String passw = request.getParameter("passwordArtist");
    			String phone = request.getParameter("phoneArtist");
    			String website = request.getParameter("websiteArtist");

    			Artist art = new Artist(1, mail, passw, phone, website, name, fname, "", "");
    			boolean test = DAOArtist.InsertArtist(art);
    			System.out.println(test);
    		}
    	}
    	
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
