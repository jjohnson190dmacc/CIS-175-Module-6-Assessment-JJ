package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 16, 2024
 */

@Entity
public class BuildListDetails {

	@Id
	@GeneratedValue
	private int listId;
	private String listName;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private BuildList buildList;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable
	private List<ComputerPart> listOfParts;
	
	public BuildListDetails() {
		super();
	}

	public BuildListDetails(String listName, BuildList buildList) {
		super();
		this.listName = listName;
		this.buildList = buildList;
	}

	public BuildListDetails(String listName, BuildList buildList, List<ComputerPart> listOfParts) {
		super();
		this.listName = listName;
		this.buildList = buildList;
		this.listOfParts = listOfParts;
	}

	public BuildListDetails(int listId, String listName, BuildList buildList, List<ComputerPart> listOfParts) {
		super();
		this.listId = listId;
		this.listName = listName;
		this.buildList = buildList;
		this.listOfParts = listOfParts;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public BuildList getBuildList() {
		return buildList;
	}

	public void setBuildList(BuildList buildList) {
		this.buildList = buildList;
	}

	public List<ComputerPart> getListOfParts() {
		return listOfParts;
	}

	public void setListOfParts(List<ComputerPart> listOfParts) {
		this.listOfParts = listOfParts;
	}

	@Override
	public String toString() {
		return "BuildListDetails [listId=" + listId + ", listName=" + listName + ", buildList=" + buildList
				+ ", listOfParts=" + listOfParts + "]";
	}
	
	
	
}
