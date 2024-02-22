package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComputerPart;

/**
 * Servlet implementation class EditPartServlet
 */
@WebServlet("/editPartServlet")
public class EditPartServlet extends HttpServlet {
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
		
		PartsHelper editPartHelper = new PartsHelper();
		
		String editManuName = request.getParameter("manuName");
		String editProdType = request.getParameter("prodType");
		String editProdName = request.getParameter("prodName");
		Integer tempID = Integer.parseInt(request.getParameter("id"));
		
		ComputerPart partToUpdate = editPartHelper.searchForItemByID(tempID);
		partToUpdate.setManufacturerName(editManuName);
		partToUpdate.setProductType(editProdType);
		partToUpdate.setProductName(editProdName);
		editPartHelper.update(partToUpdate);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
