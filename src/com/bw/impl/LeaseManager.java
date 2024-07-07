package com.bw.impl;

import com.bw.impl1.LeaseInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;

public class LeaseManager implements LeaseInterface, LeaseManager1 {

    private static final House[] houses = new House[10]; // Static array to store houses
    private static int index = 0; // Index to keep track of where to add new houses

    static {
        // Initialize the array with some sample houses
        houses[index++] = new Apartment("123 Oak St.", 100.0, false, 101);
        houses[index++] = new Villa("456 Pine Ave.", 300.0, true, 200.0);
        // Add more houses as needed
    }

    private House house;

    @Override
    public void updateLeaseStatus(String address, boolean isRented) {
        boolean finished = false;
        for (int i = 0; i < index; i++) {
            if (houses[i] != null && houses[i].getAddress().equals(address)) { // Check if the element is not null
                houses[i].setRented(isRented);
                System.out.println("House at " + address + " status updated to " + (isRented ? "rented" : "not rented"));
                finished = true;
                break;
            }
        }
        if (!finished) {
            System.out.println("No house found at address: " + address);
        }
    }
    public List<House> findHousesByArea(double minArea, double maxArea) {
        List<House> result = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            if (houses[i].getArea() >= minArea && houses[i].getArea() <= maxArea) {
                result.add(houses[i]);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No houses found within the area range.");
        }
        return result;
    }

    public List<House> findAllHouses() {
        return new ArrayList<>(Arrays.asList(houses).subList(0, index));
    }

    public void removeHouseById(int id) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (houses[i].getId() == id) {
                found = true;
                System.arraycopy(houses, i + 1, houses, i, index - i - 1);
                houses[--index] = null;
                System.out.println("House with ID " + id + " removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("No house found with ID: " + id);
        }
    }

    public BooleanSupplier getHouse() {
        return null;
    }

    public Object getHouseById() {
        return null;
    }

    public void printLeasingSlogan() {
    }

    public void addHouse(House house) {
        // Check if there's an empty slot in the houses array
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) { // If we find an empty slot
                houses[i] = house; // Add the new house passed as a parameter
                index++; // Increment the index to keep track of the number of houses
                System.out.println("House added successfully.");
                return;
            }
        }
        // If no empty slots are found, you could either throw an exception,
        // or resize the array and copy elements over, but that goes beyond this simple solution.
        System.out.println("Cannot add more houses, array is full.");
    }

    // Implement the default method from LeaseInterface if needed
}