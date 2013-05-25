package com.genart.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOArtist;
import com.genart.DAL.DAOCustomer;
import com.genart.beans.Customer;
import commons.Tools;

/**
 * Servlet implementation class CustomerDbServlet
 */
@WebServlet("/dbCustomer")
public class CustomerDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDbServlet() {
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
		String newCustomer = request.getParameter("newcustomer");
		
		if (null != request.getParameter("action"))
		{
			String action = request.getParameter("action");
			if (action.equals("delete"));
			{
				DAOCustomer.DeleteCustomer(Integer.parseInt(request.getParameter("id")));
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
			}
		}
		
		
		if (newCustomer != null){
			boolean insert = Boolean.parseBoolean(newCustomer);
			if (insert)
			{
				String mail = request.getParameter("mailCustomer");
				String password = request.getParameter("password");
				String md5 = Tools.encryptPassword(password);
				
				insertCustomer(1, mail, md5);
			}
			else
			{
				int id = Integer.parseInt(request.getParameter("id"));
				String mail = request.getParameter("mailCustomer");
				String password = request.getParameter("password");
				String md5 = Tools.encryptPassword(password);
				
				updateCustomer(id, mail, md5);
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
		}
		else
		{
			String mail = request.getParameter("mailCustomer");
			String passw = request.getParameter("passwordCustomer");
			String md5 = Tools.encryptPassword(passw);
			
			Customer custo = new Customer(1, mail, md5);
			DAOCustomer.InsertCustomer(custo);
	
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/validinscription.jsp").forward(request, response);
		}
	}
	
	private void insertCustomer(int idCustomer, String mailCustomer, String passwordCustomer)
	{
		Customer customer = new Customer(idCustomer, mailCustomer, passwordCustomer);
		DAOCustomer.InsertCustomer(customer);
	}
	
	private void updateCustomer(int idCustomer, String mailCustomer, String passwordCustomer)
	{
		Customer customer = new Customer(idCustomer, mailCustomer, passwordCustomer);
		DAOCustomer.UpdateCustomer(customer);
	}

}
