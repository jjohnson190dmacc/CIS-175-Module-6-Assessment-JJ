package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 9, 2024
 */

@Entity
@Table(name="computerInventory")
public class ComputerPart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partID;
	
	private String manufacturerName;
	private String productType;
	private String productName;
	
	public ComputerPart() {
		super();
	}

	public ComputerPart(String manufacturerName, String productType, String productName) {
		super();
		this.manufacturerName = manufacturerName;
		this.productType = productType;
		this.productName = productName;
	}

	public int getPartID() {
		return partID;
	}

	public void setPartID(int partID) {
		this.partID = partID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ComputerPart [partID=" + partID + ", manufacturerName=" + manufacturerName + ", productType="
				+ productType + ", productName=" + productName + "]";
	}
	
	
}
