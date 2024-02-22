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
 * Servlet implementation class EditBuildListDetailsServlet
 */
@WebServlet("/editBuildListDetailsServlet")
public class EditBuildListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditBuildListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuildListDetailsHelper ebldsBuildListDetailsHelper = new BuildListDetailsHelper();
		PartsHelper ebldsPartsHelper = new PartsHelper();
		BuildListHelper ebldsBuildListHelper = new BuildListHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BuildListDetails listToUpdate = ebldsBuildListDetailsHelper.searchForBuildListDetailsByID(tempId);
		
		String newListName = request.getParameter("listName");
		String buildName = request.getParameter("buildName");
		BuildList newList = ebldsBuildListHelper.findBuildList(buildName);
		
		try {
			
			String[] selectedParts = request.getParameterValues("allPartsToAdd");
			List<ComputerPart> selectedPartsInList = new ArrayList<ComputerPart>();
			
			for (int i = 0; i < selectedParts.length; i++) {
				
				System.out .println(selectedParts[i]);
				ComputerPart ebldsPart = ebldsPartsHelper.searchForItemByID(Integer.parseInt(selectedParts[i]));
				selectedPartsInList.add(ebldsPart);
				
			}
			
			listToUpdate.setListOfParts(selectedPartsInList);
			
		} catch (NullPointerException ex) {
			
			List<ComputerPart> selectedPartsInList = new ArrayList<ComputerPart>();
			listToUpdate.setListOfParts(selectedPartsInList);
			
		}
		
			listToUpdate.setListName(newListName);
			listToUpdate.setBuildList(newList);
			
			ebldsBuildListDetailsHelper.updateList(listToUpdate);
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

}
