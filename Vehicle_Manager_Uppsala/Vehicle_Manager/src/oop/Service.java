package oop;

import java.io.Serializable;

/**
 * 
 * @author Elias Posluk 
 * Student-id:(elpo7769)
 * @date 05/02/2017
 * Assignment
 * Service.Java
 * Course: 2IS200 Introduction to programming with Java
 * Uppsala University
 * 
 */

// Service performed on a vehicle
public enum Service implements Serializable {

    PREMIUM("Premium Service", 500), MEDIUM("Medium Service", 400), BUDGET("Budget Servie",
	    300), TYRE_CHANGE("Tyre Change", 200), CHIP_TUNING("Chip Tuning", 100), VARNISHING("Varnishing", 50);

    private final String name;
    private final double cost;

    private Service(String name, double cost) {
	this.name = name;
	this.cost = cost;
    }

    public String getName() {
	return name;
    }

    public double getCost() {
	return cost;
    }

    public String toString() {
        return name;
    }
}