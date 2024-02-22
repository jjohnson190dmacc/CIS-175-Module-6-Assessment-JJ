import java.util.ArrayList;
import java.util.List;

import controller.BuildListDetailsHelper;
import controller.BuildListHelper;
import model.BuildList;
import model.BuildListDetails;
import model.ComputerPart;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 16, 2024
 */


public class BuildListDetailsTester {


	public static void main(String[] args) {
		
		BuildList jeffsList = new BuildList("Jeff");
		BuildListHelper blHelper = new BuildListHelper();
		
		//String manufacturerName, String productType, String productName
		ComputerPart intelProcessor = new ComputerPart("Intel", "Processor", "Core i5 9900k");
		ComputerPart amdProcessor = new ComputerPart("AMD", "Processor", "Ryzen 5 7600x");
		
		List<ComputerPart> newListItems = new ArrayList<ComputerPart>();
		newListItems.add(intelProcessor);
		newListItems.add(amdProcessor);
		
		BuildListDetailsHelper blDetailsHelper = new BuildListDetailsHelper();
		BuildListDetails jeffsBuildList = new BuildListDetails("Jeff's List", jeffsList);
		jeffsBuildList.setListOfParts(newListItems);
		
		
		blDetailsHelper.insertNewBuildListDetails(jeffsBuildList);
		
		List<BuildListDetails> allLists = blDetailsHelper.getListDetails();
		
		for(BuildListDetails bld : allLists) {
			
			System.out.println(bld.toString());
			
		}

	}

}
