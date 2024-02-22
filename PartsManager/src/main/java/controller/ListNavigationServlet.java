package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BuildListDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuildListDetailsHelper navServletBLDHelper = new BuildListDetailsHelper();
		String action = request.getParameter("doThisToList");
		
		if (action == null) {
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			
		} else if (action.equals("delete")) {
			
			try {
				
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				BuildListDetails listToDelete = navServletBLDHelper.searchForBuildListDetailsByID(tempID);
				navServletBLDHelper.deleteList(listToDelete);
				
			} catch (NumberFormatException e) {
				
				System.out.println("Forgot to Make a Choice");
				
			} finally {
				
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}
			
		} else if (action.equals("update")) {
			
			try {
				
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				BuildListDetails listToUpdate = navServletBLDHelper.searchForBuildListDetailsByID(tempID);			
				request.setAttribute("listToUpdate", listToUpdate);
				
				PartsHelper helperForParts = new PartsHelper();				
				request.setAttribute("allItems", helperForParts.showAllParts());
				
				if (helperForParts.showAllParts().isEmpty()) {
					
					request.setAttribute("allItems", " ");
				}
				
				getServletContext().getRequestDispatcher("/EditList.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				
			}
			
		} else if (action.equals("add")) {
			
			getServletContext().getRequestDispatcher("/NewPartsList.jsp").forward(request, response);
			
		}



	}
}
