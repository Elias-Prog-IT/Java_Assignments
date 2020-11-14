package oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Elias Posluk 
 * Student-id:(elpo7769)
 * @date 05/02/2017
 * Assignment
 * Workshop.Java
 * Course: 2IS200 Introduction to programming with Java
 * Uppsala University
 * 
 */

// Class to hold list of vehicles
public class Workshop {

    // input and output file
    private static final String DATA_FILE = "vehicles.ser";

    private ArrayList<Vehicle> vehicles; // to hold list of vehicles

    public Workshop() {
        vehicles = new ArrayList<>();
        read(); // read from file
    }

    // add a new vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        save();
    }

    // add a work performed
    public void addWorkDone(String regNumber, Service service) {
        Vehicle vehicle = search(regNumber);
        if (vehicle == null || vehicle.isRepaired()) {
            throw new RuntimeException("Vehicle not found or already repaired.");
        }

        vehicle.addService(service);
        save();
    }

    // search a vehicle
    public Vehicle search(String regNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegNumber().equalsIgnoreCase(regNumber)) {
                return vehicle;
            }
        }

        return null;
    }

    // move vehicle to repaired
    public void addToRepaired(String regNumber) {
        Vehicle vehicle = search(regNumber);
        if (vehicle == null || vehicle.isRepaired()) {
            throw new RuntimeException("Vehicle not found or already repaired.");
        }

        vehicle.setRepaired(true);
        save();

    }

    // check out
    public Vehicle checkOut(String regNumber) {
        Vehicle vehicle = search(regNumber);
        if (vehicle == null || !vehicle.isRepaired()) {
            throw new RuntimeException("Vehicle not found or not repaired yet.");
        }

        vehicles.remove(vehicle);
        save();

        return vehicle;
    }

    // get all vehicles repaired/ work in pregress
    public ArrayList<Vehicle> getVehicles(boolean repaired) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isRepaired() == repaired) {
                result.add(vehicle);
            }
        }

        return result;
    }

    // read list of vehicles from file
    private void read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE));
            vehicles = (ArrayList<Vehicle>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
        }
    }

    // save list of vehicles in file
    private void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
            oos.writeObject(vehicles);
            oos.close();
        } catch (IOException ex) {
        }
    }

}