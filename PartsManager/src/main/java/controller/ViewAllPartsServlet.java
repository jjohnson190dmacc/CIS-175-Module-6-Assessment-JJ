package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllPartsServlet
 */
@WebServlet("/viewAllPartsServlet")
public class ViewAllPartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PartsHelper viewPartsHelper = new PartsHelper();
		request.setAttribute("allParts", viewPartsHelper.showAllParts());
		String browserPath = "/ViewParts.jsp";
		
		if(viewPartsHelper.showAllParts().isEmpty()) {
			browserPath = "/index.jsp";
		}
		
		getServletContext().getRequestDispatcher(browserPath).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
