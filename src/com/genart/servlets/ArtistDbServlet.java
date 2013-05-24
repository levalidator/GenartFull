package com.genart.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOArtist;
import com.genart.beans.Artist;

import commons.Tools;

/**
 * Servlet implementation class ArtistDbServlet
 */
@WebServlet("/dbArtist")
public class ArtistDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newUser = request.getParameter("newuser");
		
		if (newUser!= null)
		{
			Boolean insert = Boolean.parseBoolean(newUser);
			if (insert)
			{
				String name = request.getParameter("name");
				String fname = request.getParameter("firstname");
    			String mail = request.getParameter("mailArtist");
    			String passw = request.getParameter("password");
    			String phone = request.getParameter("phone");
    			String website = request.getParameter("website");
    			String md5 = Tools.encryptPassword(passw);
				
    			insertArtist(1, mail, md5, phone, website, name, fname, "", "img/artist.jpg");
    			
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
			}
			else
			{
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String fname = request.getParameter("firstname");
    			String mail = request.getParameter("mailArtist");
    			String passw = request.getParameter("password");
    			String phone = request.getParameter("phone");
    			String website = request.getParameter("website");
    			String md5 = Tools.encryptPassword(passw);
    			
				updateArtist(id, mail, md5, phone, website, name, fname, "", "img/artist.jpg");
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
			}
		}
		else
		{
			String name = request.getParameter("nameArtist");
			String fname = request.getParameter("firstnameArtist");
			String mail = request.getParameter("mailArtist");
			String passw = request.getParameter("passwordArtist");
			String phone = request.getParameter("phoneArtist");
			String website = request.getParameter("websiteArtist");
			String md5 = Tools.encryptPassword(passw);
			
			insertArtist(1, mail, md5, phone, website, name, fname, "", "img/artist.jpg");
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/validinscription.jsp").forward(request, response);
		}
	}
	

	private void insertArtist(int id, String mail, String md5, String phone, String website, String name, String fname, String description, String pathAvatar)
	{
		Artist artist = new Artist(id, mail, md5, phone, website, name, fname, description, pathAvatar);
		DAOArtist.InsertArtist(artist);
	}
	
	private void updateArtist(int id, String mail, String md5, String phone, String website, String name, String fname, String description, String pathAvatar)
	{
		Artist artist = new Artist(id, mail, md5, phone, website, name, fname, description, pathAvatar);
		DAOArtist.UpdateArtist(artist);
	}

}
