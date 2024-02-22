package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 16, 2024
 */

@Entity
@Table(name = "buildlist")
public class BuildList {

	@Id
	@GeneratedValue
	private int buildId;
	private String buildName;
	
	public BuildList() {
		super();
	}

	public BuildList(String buildName) {
		super();
		this.buildName = buildName;
	}

	public BuildList(int buildId, String buildName) {
		super();
		this.buildId = buildId;
		this.buildName = buildName;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	@Override
	public String toString() {
		return "BuildList [buildId=" + buildId + ", buildName=" + buildName + "]";
	}
	
	
	
}
