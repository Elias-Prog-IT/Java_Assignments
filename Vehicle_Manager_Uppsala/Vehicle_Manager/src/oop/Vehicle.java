package oop;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Elias Posluk 
 * Student-id:(elpo7769)
 * @date 05/02/2017
 * Assignment
 * Vehicle.Java
 * Course: 2IS200 Introduction to programming with Java
 * Uppsala University
 * 
 */

// This class represents a vehicle
public abstract class Vehicle implements Serializable {

    // constants
    private static final int MIN_MILES = 1500, MAX_MILES = 40000;

    // vehicle details
    private String regNumber;
    private String brand;
    private String owner;
    private int miles;
    private int year;
    private int daysToRepair;
    private Date date;
    private String serviceType;
    private ArrayList<Service> services;
    private boolean repaired;

    // constructor to create a new vehicle
    public Vehicle(String regNumber, String brand, String owner, int year) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.owner = owner;
        this.year = year;

        date = Calendar.getInstance().getTime();
        miles = generateMiles();
        daysToRepair = numberOfDays(miles);
        serviceType = getServiceType(miles);

        services = new ArrayList<>();
        repaired = false;
    }

    // Getter methods
    public String getRegNumber() {
        return regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwner() {
        return owner;
    }

    public int getMiles() {
        return miles;
    }

    public int getYear() {
        return year;
    }

    public int getDaysToRepair() {
        return daysToRepair;
    }

    public Date getDate() {
        return date;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public double totalCost() {
        double total = 0;
        for (Service service : services) {
            total += service.getCost();
        }
        return total;
    }

    public abstract String getType();

    // generate random mileage
    private static int generateMiles() {
        return MIN_MILES + new Random().nextInt(MAX_MILES - MIN_MILES);
    }

    // get service type
    public static String getServiceType(int mileage) {
        if (mileage <= 8000) {
            return "Small Service";
        } else if (mileage <= 20000) {
            return "Medium Service";
        } else {
            return "Big Service";
        }
    }

    public static int numberOfDays(int mileage) {
        return mileage / MIN_MILES;
    }

    // string representation of the vehicle
    public String toString() {
        String out = String.format(
                "%s %s" + "\nModel Year: %d" + "\nOwner: %s" + "\nMileage: %s mil" + "\nSubmitted: %s"
                + "\nEstimated time to repair: %d days" + "\n%s recommended",
                brand, regNumber, year, owner, miles, new SimpleDateFormat("EEE MMM dd").format(date), daysToRepair,
                serviceType);

        if (!services.isEmpty()) {
            out += "\nWork Done: ";
            for (Service service : services) {
                out += "\n - " + service.getName() + " [$" + service.getCost() + "]";
            }

        }

        out += "\nStatus: " + (repaired ? "Ready to be collected" : "Work in progress");

        return out;

    }

}