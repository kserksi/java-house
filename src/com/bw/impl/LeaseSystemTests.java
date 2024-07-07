package com.bw.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LeaseSystemTests {

    private LeaseManager leaseManager;

    @BeforeEach
    public void setUp() {
        leaseManager = new LeaseManager();
    }

    @Test
    public void testUpdateLeaseStatus() {
        String address = "123 Main St.";
        House house = new House(address, 100.0, false) {
            @Override
            public int getId() {
                return 0;
            }
        }; // Create a new house instance
        leaseManager.addHouse(house); // Add the house to the LeaseManager

        boolean isRented = true;
        leaseManager.updateLeaseStatus(address, isRented);

        // Retrieve the updated house to verify its status
        List<House> allHouses = leaseManager.findAllHouses();
        House updatedHouse = allHouses.stream()
                .filter(h -> h.getAddress().equals(address))
                .findFirst()
                .orElse(null);

        assertNotNull(updatedHouse, "House should exist after being added or updated.");
        assertFalse(updatedHouse.isRented(), "House should be rented after update.");
    }
    @Test
    public void testFindHousesByArea() {
        double minArea = 50.0;
        double maxArea = 100.0;
        List<House> housesInAreaRange = leaseManager.findHousesByArea(minArea, maxArea);
        assertFalse(housesInAreaRange.isEmpty(), "No houses found in the specified area range.");
    }

    @Test
    public void testFindAllHouses() {
        List<House> allHouses = leaseManager.findAllHouses(); // Assuming it returns all houses
        assertFalse(allHouses.isEmpty(), "No houses found.");
    }

    @Test
    public void testRemoveHouseById() {
        int houseId = 1;
        // Assuming there's a method to add a house with a specific ID
        House houseToBeRemoved = new House("Some Address", 150.0, false) {
            @Override
            public int getId() {
                return houseId;
            }
        };
        leaseManager.addHouse(houseToBeRemoved);

        leaseManager.removeHouseById(houseId);

        List<House> allHouses = leaseManager.findAllHouses();
        House removedHouse = allHouses.stream()
                .filter(h -> h.getId() == houseId)
                .findFirst()
                .orElse(null);
        assertNull(removedHouse, "House with ID " + houseId + " should be removed.");
    }

    @Test
    public void testPrintLeasingSlogan() {
        leaseManager.printLeasingSlogan();
        // This test assumes the method prints to console, which cannot be directly verified here.
        // You may want to capture console output for verification if necessary.
    }
    @Test
    public void testAddHouse() {
        String address = "123 Main St.";
        double area = 100.0;
        boolean isRented = false;
        House newHouse = new House(address, area, isRented) {
            @Override
            public int getId() {
                return 0;
            }
        };

        leaseManager.addHouse(newHouse); // Pass the new house to the addHouse method

        // Optionally, you can check if the house was added correctly
        List<House> allHouses = leaseManager.findAllHouses();
        assertTrue(allHouses.contains(newHouse), "The house should be added to the manager.");
    }
}