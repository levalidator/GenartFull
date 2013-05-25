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
import javax.servlet.http.HttpSession;

import com.genart.DAL.DAOOrder;
import com.genart.DAL.DAOSupport;
import com.genart.DAL.DAOTemplate;
import com.genart.beans.Artist;
import com.genart.beans.Customer;
import com.genart.beans.Order;
import com.genart.beans.OrderLine;
import com.genart.beans.Sketch;
import com.genart.beans.Support;
import com.genart.beans.Template;
import commons.SessionManager;

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
		
		float montantTotal = 0;
		int nbOeuvres = 0;
		
		for(Support support : DAOSupport.GetListSupport())
			supports.put(support.getId(), support);

		for(Template template : DAOTemplate.GetListTemplates())
			templates.put(template.getId(), template);
		
		if (sketchs != null)
		{
			nbOeuvres = sketchs.size();
			for(Sketch sketch : sketchs)
				montantTotal += templates.get(sketch.getIdTemplate()).getMontant() + supports.get(sketch.getId()).getMontant();
		}

		request.setAttribute("templates", templates);
		request.setAttribute("supports", supports);
		request.setAttribute("sketchs", sketchs);
		request.setAttribute("montantTotal", montantTotal);
		
		HttpSession session = request.getSession();
		if (session != null)
			session.setAttribute("nbOeuvres", nbOeuvres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action").toString();
		System.out.println(action);
		if (action.equals("add"))
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
			String imageValue = "";
			Object image = request.getSession().getAttribute(request.getSession().getId() + "_" + numSkecth);
			if(image != null)
			{
				imageValue = image.toString();
			}
			//sketchs.add(new Sketch(idSupport, idTemplate, "img/temp/" + request.getSession().getId() + "_" + numSkecth + ".jpg", sketchs.size()));
			sketchs.add(new Sketch(idSupport, idTemplate, imageValue, sketchs.size()));
			++numSkecth;
			
			request.getSession().setAttribute("numSkecth", numSkecth);
			request.getSession().setAttribute("sketchs", sketchs);
			
			response.sendRedirect("./cart");
		}
		
		if (action.equals("delete"))
		{
			System.out.println("entrée delte");
			if (null != request.getParameter("numero"))
			{
				System.out.println("id not null");
				int numSketch = Integer.parseInt(request.getParameter("numero").toString());
				List<Sketch> sketchs = (List<Sketch>)request.getSession().getAttribute("sketchs");
				
				if (sketchs != null)
				{
					Sketch currentSketch = null;
					for (Sketch sketch : sketchs)
						if (sketch.getNumero() == numSketch)
							currentSketch = sketch;
					
					sketchs.remove(currentSketch);
					System.out.println("deleted");
				}
			}
			response.sendRedirect("./cart");
		}
		
		if (action.equals("paiement"))
		{
			if(!SessionManager.isConnected(request.getSession()))
			{
				response.sendRedirect("./connexion");
				return;
			}
			List<Sketch> sketchs = (List<Sketch>)request.getSession().getAttribute("sketchs");

			Order order = new Order();
			order.setLignes(new ArrayList<OrderLine>());
			
			Artist artist = null;
			Customer customer = null;
			
			if((artist = SessionManager.getConnectedArtist(request.getSession())) != null)
			{
				order.setIdCustomer(artist.getId());
			}
			else if((customer = SessionManager.getConnectedCustomer(request.getSession())) != null)
			{
				order.setIdCustomer(customer.getIdCustomer());
			}
			
			for(Sketch sketch : sketchs)
			{
				OrderLine line = new OrderLine();
				line.setIdSketch(sketch.getIdTemplate());
				line.setIdSupport(sketch.getId());
				order.getLignes().add(line);
			}
			
			DAOOrder.insertOrder(order);
			
			response.sendRedirect("./cart");
		}
	}
}
