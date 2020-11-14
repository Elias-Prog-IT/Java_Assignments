package oop;

import java.io.Serializable;

/**
/**
 * 
 * @author Elias Posluk 
 * Student-id:(elpo7769)
 * @date 05/02/2017
 * Assignment
 * Motorcycle.Java
 * Course: 2IS200 Introduction to programming with Java
 * Uppsala University
 * 
 */

// Motorycle
public class Motorcycle extends Vehicle implements Serializable{

    public Motorcycle(String regNumber, String brand, String owner, int year) {
	super(regNumber, brand, owner, year);
    }

    
    public String getType() {
	return "Motorcycle";
    }
    
     

}