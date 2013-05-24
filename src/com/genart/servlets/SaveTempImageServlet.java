package com.genart.servlets;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/saveimgtemp")
public class SaveTempImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTempImageServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{        
		BASE64Decoder decoder = new BASE64Decoder(); 
		
		String param = request.getParameter("image").toString().split(",")[1];
		
	    byte[] imgBytes = decoder.decodeBuffer(param);          
	    
	    ByteArrayInputStream stream = new ByteArrayInputStream(imgBytes);
	    
	    BufferedImage bufImg = ImageIO.read(stream);  
	    
	    String sessionId = request.getSession().getId();

		int numSkecth = 0;
		Object num = request.getSession().getAttribute("numSkecth");
		request.getSession().setAttribute(sessionId + "_" + numSkecth, request.getParameter("image").toString());
		if(num != null)
		{
			numSkecth = Integer.parseInt(num.toString()); 
		}
		request.getSession().setAttribute("numSkecth", numSkecth);
		//C:\\Eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\GenArt\\img\\temp\\
		//File imgOutFile = new File("C:\\Eclipse\\workspace\\GenArt\\WebContent\\img\\temp\\" + sessionId + "_" + numSkecth + ".jpg");
		//File imgOutFile = new File("C:\\Eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\GenArt\\img\\temp\\" + sessionId + "_" + numSkecth + ".jpg");
	    //File imgOutFile = new File("/Users/romanleichnig/Projets/Java EE/Genart/WebContent/img/temp/" + sessionId + "_" + numSkecth + ".jpg");
	    
		//ImageIO.write(bufImg, "jpg", imgOutFile); 
	}
}
