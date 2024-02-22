package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComputerPart;

/**
 * Servlet implementation class NavigationController
 */
@WebServlet("/navigationController")
public class NavigationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PartsHelper naviPartsHelper = new PartsHelper();
		String userChoice = request.getParameter("userChoiceForPart");
		String broswerPath = "/viewAllPartsServlet";
		
		if (userChoice.equals("add")) {
			
			broswerPath = "/index.jsp";
			
		}else if (userChoice.equals("update")) {
			
			try {
				
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				ComputerPart partToUpdate = naviPartsHelper.searchForItemByID(tempID);
				request.setAttribute("partToUpdate", partToUpdate);
				
				broswerPath = "/UpdatePart.jsp";
				
			}catch(NumberFormatException e) {
				
				System.out.println("Forgot to make a selection");
				
			}			
			
		}else if (userChoice.equals("delete")) {
			
			try {
				
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				ComputerPart partToDelete = naviPartsHelper.searchForItemByID(tempID);
				naviPartsHelper.delete(partToDelete);
				
			}catch(NumberFormatException e) {
				
				System.out.println("Forgot to make a selection");
				
			}			
			
		}
		
		getServletContext().getRequestDispatcher(broswerPath).forward(request, response);
		
	}

}
