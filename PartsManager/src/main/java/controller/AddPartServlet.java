package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComputerPart;

/**
 * Servlet implementation class AddPartServlet
 */
@WebServlet("/addPartServlet")
public class AddPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addManuName = request.getParameter("manuName");
		String addProdType = request.getParameter("prodType");
		String addProdName = request.getParameter("prodName");
		
		ComputerPart newPart = new ComputerPart(addManuName,addProdType,addProdName);
		PartsHelper addPartHelper = new PartsHelper();
		addPartHelper.insertItem(newPart);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
