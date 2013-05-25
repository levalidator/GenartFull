package com.genart.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.genart.DAL.DAOAdministrator;
import com.genart.DAL.DAOArtist;
import com.genart.DAL.DAOCustomer;
import com.genart.beans.Administrator;
import com.genart.beans.Artist;
import com.genart.beans.Customer;
import commons.Tools;

@SuppressWarnings("serial")
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	public ConnexionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		boolean connected;
		try {
			connected = (Boolean) session.getAttribute("connected");
		} catch (Exception e) {
			connected = false;
			System.out.println(e.getMessage());
		}
		if (connected) {
			request.setAttribute("connected", true);
		} else {
			request.setAttribute("connected", false);
		}
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/connexion.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer custo = DAOCustomer.GetCustomerByMail(request.getParameter("login"));
		Artist artist = DAOArtist.GetArtistByMail(request.getParameter("login"));
		Administrator admin = DAOAdministrator.GetAdministratorByMail(request.getParameter("login"));
		String passw = request.getParameter("password");
		HttpSession session = request.getSession();
		String param = null;
		String md5 = Tools.encryptPassword(passw);

		if (null != custo) {
			if (custo.getPasswordCustomer().equals(md5)) {
				session.setAttribute("customer", custo);
				session.setAttribute("connected", true);
				session.setAttribute("isCustomer", true);
				param = "connected";
				request.setAttribute("result", param);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/validconnexion.jsp").forward(request, response);
			} else {
				param = "errorPassw";
				request.setAttribute("result", param);
				session.setAttribute("connected", false);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/errorconnexion.jsp").forward(request, response);
			}
		}

		if (null != artist) {
			if (artist.getPassword().equals(md5)) {
				session.setAttribute("artist", artist);
				session.setAttribute("connected", true);
				session.setAttribute("isCustomer", false);
				param = "connected";
				request.setAttribute("result", param);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/validconnexion.jsp").forward(request, response);
			} else {
				param = "errorPassw";
				session.setAttribute("connected", false);
				request.setAttribute("result", param);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/errorconnexion.jsp").forward(request, response);
			}
		}
		
		if (null != admin) {
			if (admin.getPasswordAdministrator().equals(md5)){
				session.setAttribute("admin", admin);
				session.setAttribute("connected", true);
				session.setAttribute("isCustomer", false);
				session.setAttribute("userType", "admin");
				param = "connected";
				request.setAttribute("result", param);
				
				response.sendRedirect("./admin");
			} else {
				session.setAttribute("connected", false);
				request.setAttribute("result", param);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/errorconnexion.jsp").forward(request, response);
			}
		}

		if ((null == artist) && (null == custo) && (null == admin)) {
			param = "error";
			request.setAttribute("result", param);
			session.setAttribute("isCustomer", false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/errorconnexion.jsp").forward(request, response);
		}

	}

}
