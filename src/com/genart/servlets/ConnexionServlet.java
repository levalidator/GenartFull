package com.genart.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOArtist;
import com.genart.DAL.DAOCustomer;
import com.genart.bdd.AccesBDD;
import com.genart.beans.Artist;
import com.genart.beans.Customer;

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

    			MessageDigest encryptedPass;
				try {
					encryptedPass = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					encryptedPass = null;
					e.printStackTrace();
				} 
				
    			encryptedPass.update(passw.getBytes(), 0, passw.length());
    			String md5 = new BigInteger(1, encryptedPass.digest()).toString(16);
    			
    			Artist art = new Artist(1, mail, md5, phone, website, name, fname, "", "img/artist.jpg");
    			DAOArtist.InsertArtist(art);
    		}
    		
    		if (object.equals("customer")){
    			String mail = request.getParameter("mailCustomer");
    			String passw = request.getParameter("passwordCustomer");
    			
    			MessageDigest encryptedPass;
				try {
					encryptedPass = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					encryptedPass = null;
					e.printStackTrace();
				} 
				
    			encryptedPass.update(passw.getBytes(), 0, passw.length());
    			String md5 = new BigInteger(1, encryptedPass.digest()).toString(16);
    			
    			Customer custo = new Customer(1, mail, md5);
    			DAOCustomer.InsertCustomer(custo);
    		}
    	}
    	
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
