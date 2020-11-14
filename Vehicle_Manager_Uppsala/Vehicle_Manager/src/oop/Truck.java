package oop;

import java.io.Serializable;


/**
 * 
 * @author Elias Posluk 
 * Student-id:(elpo7769)
 * @date 05/02/2017
 * Assignment
 * Truck.Java
 * Course: 2IS200 Introduction to programming with Java
 * Uppsala University
 * 
 */

// Truck
public class Truck extends Vehicle implements Serializable{

    public Truck(String regNumber, String brand, String owner, int year) {
	super(regNumber, brand, owner, year);
    }

   
    public String getType() {
	return "Truck";
    }
    
     

}