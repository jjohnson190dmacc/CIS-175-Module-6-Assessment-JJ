package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BuildList;
import model.BuildListDetails;
import model.ComputerPart;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PartsHelper newListPartHelper = new PartsHelper();
		String newListName = request.getParameter("newListName");
		System.out.println("List Name: " + newListName);
		
		String newBuildName = request.getParameter("newBuildName");
		String[] chosenParts = request.getParameterValues("allPartsToAdd");
		
		List<ComputerPart> selectedPartsInList = new ArrayList<ComputerPart>();
		
		if (chosenParts != null && chosenParts.length > 0) {
			
			for (int i = 0; i < chosenParts.length; i++) {
				
				System.out.println(chosenParts[i]);
				ComputerPart cnlServletForLoopParts = newListPartHelper.searchForItemByID(Integer.parseInt(chosenParts[i]));
				selectedPartsInList.add(cnlServletForLoopParts);
				
			}
			
		}
		
		BuildList cnlServletList = new BuildList(newListName);
		BuildListDetails cnlNewBLD = new BuildListDetails(newListName,cnlServletList);
		
		cnlNewBLD.setListOfParts(selectedPartsInList);
		
		BuildListDetailsHelper cnlServletBLH = new BuildListDetailsHelper();
		cnlServletBLH.insertNewBuildListDetails(cnlNewBLD);
		
		System.out.println(cnlNewBLD.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
