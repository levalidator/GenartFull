package com.genart.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.genart.DAL.DAOSupport;
import com.genart.DAL.DAOTemplate;
import com.genart.beans.Support;
import com.genart.beans.Template;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Object add = request.getAttribute("add");
		
		if(add != null)
		{
			int idTemplate = Integer.parseInt(request.getAttribute("id").toString());
			int idSupport = Integer.parseInt(request.getAttribute("support").toString());
			
		}
		else
		{		
			List<Template> templates = DAOTemplate.GetListTemplates();
			Map<Integer, Support> supports = new HashMap<Integer, Support>();
	
			for(Support support : DAOSupport.GetListSupport())
			{
				supports.put(support.getId(), support);
			}
	
			request.setAttribute("templates", templates);
			request.setAttribute("supports", supports);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

}
