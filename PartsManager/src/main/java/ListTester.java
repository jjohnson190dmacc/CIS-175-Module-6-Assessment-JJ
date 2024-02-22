import java.util.List;

import controller.BuildListHelper;
import model.BuildList;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 16, 2024
 */
public class ListTester {


	public static void main(String[] args) {
		
		BuildList newList = new BuildList("Jeff's List");
		BuildList secondList = new BuildList("Mark's List");
		BuildListHelper blh = new BuildListHelper();
		
		blh.insertBuildList(newList);
		blh.insertBuildList(secondList);
		
		List<BuildList> allBuildLists = blh.showAllLists();
		
		for (BuildList list : allBuildLists) {
			
			System.out.println(list.toString());
			
		}

	}

}
