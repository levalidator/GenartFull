package com.genart.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		System.out.println("good");
		
		if (newCustomer != null){
			System.out.println("dispatch");
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

}
