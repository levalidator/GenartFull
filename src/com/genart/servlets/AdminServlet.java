package com.genart.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.genart.DAL.DAOArtist;
import com.genart.DAL.DAOCustomer;
import com.genart.DAL.DAOSupport;
import com.genart.DAL.DAOTemplate;
import com.genart.beans.Artist;
import com.genart.beans.Customer;
import com.genart.beans.Support;
import com.genart.beans.Template;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		boolean connected = false;
		if (null != session.getAttribute("connected"))
			connected = Boolean.parseBoolean(session.getAttribute("connected").toString());
		
		String userType = "";
		if (null != session.getAttribute("userType"))
			userType = session.getAttribute("userType").toString();
		
		if (connected)
		{
			if (userType.equals("admin"))
			{
				List<Artist> artists = DAOArtist.getListArtist(0);
				List<Customer> customers = DAOCustomer.GetListCustomer(0);
				List<Support> supports = DAOSupport.GetListSupport(); 
				int maxIdArtist = DAOArtist.GetNextId();
				//int maxIdCustomer = DAOCustomer.GetNextId();
				
				request.setAttribute("artists", artists);
				request.setAttribute("customers", customers);
				request.setAttribute("products", supports);
				request.setAttribute("maxIdArtist", maxIdArtist);
				//request.setAttribute("maxIdCustomer", maxIdCustomer);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
