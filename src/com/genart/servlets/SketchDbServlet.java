package com.genart.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOCustomer;
import com.genart.DAL.DAOTemplate;

/**
 * Servlet implementation class SketchDbServlet
 */
@WebServlet("/dbTemplate")
public class SketchDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SketchDbServlet() {
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
		if (null != request.getParameter("action"))
		{
			String action = request.getParameter("action");
			if (action.equals("delete"));
			{
				DAOTemplate.DeleteTemplate(Integer.parseInt(request.getParameter("id")));
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
	}

}
