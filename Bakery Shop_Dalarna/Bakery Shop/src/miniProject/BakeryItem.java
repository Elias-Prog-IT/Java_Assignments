/**
 * 
 * @author Elias Posluk 
 * Student-id:(h16elipo)
 * @date 20/05/2019
 * MiniProject
 * BakeryItem.Java
 * Course: IK1052 - Introduction to object-oriented programming in java
 * Dalarna University
 * 
 */

package miniProject;

import java.util.Date;


// This class represent a bakery item
public class BakeryItem {

	// item details
	private String name;
	private String description;
	private boolean brokenPackaging;
	private double value;
	private Date produced;
	
	// constructor
	public BakeryItem(String name, String description, boolean brokenPackaging, double value, Date produced) {
		this.name = name;
		this.description = description;
		this.brokenPackaging = brokenPackaging;
		this.value = value;
		this.produced = produced;
	}
	
	
	// Getters and Setters

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isBrokenPackaging() {
		return brokenPackaging;
	}
	
	public String brokenPackaging() {
		return brokenPackaging ? "Yes" : "No";
	}

	public double getValue() {
		return value;
	}

	public Date getProduced() {
		return produced;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBrokenPackaging(boolean brokenPackaging) {
		this.brokenPackaging = brokenPackaging;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setProduced(Date produced) {
		this.produced = produced;
	}

}