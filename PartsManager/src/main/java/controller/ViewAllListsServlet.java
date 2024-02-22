package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BuildListDetails;

/**
 * Servlet implementation class ViewAllListsSerlet
 */
@WebServlet("/viewAllListsServlet")
public class ViewAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewAllListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuildListDetailsHelper bldHelper = new BuildListDetailsHelper();
		List<BuildListDetails> detailsList = bldHelper.getListDetails();
		
		request.setAttribute("allLists", detailsList);
		
		if (detailsList.isEmpty()) {
			request.setAttribute("allLists", " ");
		}
		
		getServletContext().getRequestDispatcher("/BuildListByUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
