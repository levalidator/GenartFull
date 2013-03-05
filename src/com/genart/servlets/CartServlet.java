package com.genart.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import com.genart.beans.Sketch;
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
		List<Sketch> sketchs = (List<Sketch>)request.getSession().getAttribute("sketchs");
		Map<Integer, Support> supports = new HashMap<Integer, Support>();
		Map<Integer, Template> templates = new HashMap<Integer, Template>();

		for(Support support : DAOSupport.GetListSupport())
		{
			supports.put(support.getId(), support);
		}
		for(Template template : DAOTemplate.GetListTemplates())
		{
			templates.put(template.getId(), template);
		}

		request.setAttribute("templates", templates);
		request.setAttribute("supports", supports);
		request.setAttribute("sketchs", sketchs);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int idTemplate = Integer.parseInt(request.getParameter("idTemplate").toString());
		
	 	Object idsupport = request.getParameter("idSupport");
		
		int idSupport = 0;

		try
		{
			idSupport = Integer.parseInt(request.getParameter("idSupport").toString());
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		int numSkecth = 0;
		Object num = request.getSession().getAttribute("numSkecth");
		if(num != null)
		{
			numSkecth = Integer.parseInt(num.toString()); 
		}
		
		List<Sketch> sketchs = (List<Sketch>)request.getSession().getAttribute("sketchs");
		if(sketchs == null)
		{
			sketchs = new ArrayList<Sketch>();
		}
		sketchs.add(new Sketch(idSupport, idTemplate, "img/temp/" + request.getSession().getId() + "_" + numSkecth + ".jpg"));
		++numSkecth;
		request.getSession().setAttribute("numSkecth", numSkecth);
		request.getSession().setAttribute("sketchs", sketchs);
		
		response.sendRedirect("./cart");
	}
}
