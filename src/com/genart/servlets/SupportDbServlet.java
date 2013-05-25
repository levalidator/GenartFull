package com.genart.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOSupport;
import com.genart.beans.Support;

import commons.Tools;

/**
 * Servlet implementation class SupportDbServlet
 */
@WebServlet("/dbSupport")
public class SupportDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportDbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newProduct = request.getParameter("newproduct");
		
		if (null != request.getParameter("action"))
		{
			String action = request.getParameter("action");
			if (action.equals("delete"));
			{
				DAOSupport.DeleteSupport(Integer.parseInt(request.getParameter("id")));
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
			}
		}
		
		if (newProduct != null){
			boolean insert = Boolean.parseBoolean(newProduct);
			if (insert)
			{
				String name = request.getParameter("name");
				float price = Float.parseFloat(request.getParameter("price"));
				String description = request.getParameter("description");
				float dimx = Float.parseFloat(request.getParameter("dimx"));
				float dimy = Float.parseFloat(request.getParameter("dimy"));
				float dimz = Float.parseFloat(request.getParameter("dimz"));
				
				insertSupport(1, dimx, dimy, dimz, name, description, price);
			}
			else
			{
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				float price = Float.parseFloat(request.getParameter("price"));
				String description = request.getParameter("description");
				float dimx = Float.parseFloat(request.getParameter("dimx"));
				float dimy = Float.parseFloat(request.getParameter("dimy"));
				float dimz = Float.parseFloat(request.getParameter("dimz"));
				
				updateSupport(id, dimx, dimy, dimz, name, description, price);
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
		}
	}
	
	private void insertSupport(int id, float dimension_x, float dimension_y, float dimension_z, String name, String description, float montant)
	{
		Support support = new Support(id,  dimension_x, dimension_y, dimension_z, name, description, montant);
		DAOSupport.InsertSupport(support);
	}
	
	private void updateSupport(int id, float dimension_x, float dimension_y, float dimension_z, String name, String description, float montant)
	{
		Support support = new Support(id,  dimension_x, dimension_y, dimension_z, name, description, montant);
		DAOSupport.UpdateSupport(support);
	}

}
