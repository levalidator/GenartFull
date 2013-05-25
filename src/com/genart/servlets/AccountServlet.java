package com.genart.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.genart.DAL.DAOOrder;
import com.genart.beans.Customer;
import com.genart.beans.Order;
import commons.SessionManager;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/MyAccount")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionManager.isConnected(request.getSession()))
		{
			HttpSession session = request.getSession();
			
			if (session.getAttribute("customer") != null && session.getAttribute("customer").getClass() == (Customer.class))
			{
				List<Order> orders = DAOOrder.getListOrder(((Customer)session.getAttribute("customer")).getIdCustomer());
				request.setAttribute("orders", orders);
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/account.jsp").forward(request, response);
			}
			else
			{
				response.sendRedirect("");
			}
		}
		else
		{
			response.sendRedirect("");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
