package oop;

import java.io.Serializable;

/**
 * 
 * @author Elias Posluk 
 * Student-id:(elpo7769)
 * @date 05/02/2017
 * Assignment
 * Car.Java
 * Course: 2IS200 Introduction to programming with Java
 * Uppsala University
 * 
 */

// Represents a car
public class Car extends Vehicle implements Serializable {

    public Car(String regNumber, String brand, String owner, int year) {
        super(regNumber, brand, owner, year);
    }

    // type of vehicle
    public String getType() {
        return "Car";
    }

}