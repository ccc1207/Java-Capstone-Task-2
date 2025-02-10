package quickFood;

import java.io.BufferedReader;

/**
 * The FindBestDriver class is responsible for selecting the most suitable driver
 * based on the restaurant's location and the driver's availability.
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The FindBestDriver class is responsible for selecting the most suitable driver
 * based on the restaurant's location and the driver's availability.
 */
public class FindBestDriver {

    /**
     * Finds the best available driver for a given restaurant city.
     * The driver with the lowest current load from the same city is selected.
     *
     * @param restaurantCity The city where the restaurant is located.
     * @return The best driver available or null if no driver is found.
     */
    public static Driver findDriver(String restaurantCity) {
        Driver bestDriver = null;  // Variable to store the best driver found
        List<Driver> drivers = new ArrayList<>();  // List to store drivers from the same city

        // Read the list of drivers from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");  // Split line into name, city, and load

                // Ensure that the line has exactly 3 elements (name, city, load)
                if (details.length == 3) {
                    String driverName = details[0].trim();
                    String driverCity = details[1].trim();

                    try {
                        int driverLoad = Integer.parseInt(details[2].trim());  // Convert load to an integer

                        // Check if the driver operates in the same city as the restaurant
                        if (driverCity.equalsIgnoreCase(restaurantCity)) {
                            drivers.add(new Driver(driverName, driverCity, driverLoad));
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid driver load value in file: " + details[2]);
                    }
                }
            }

            // Select the driver with the lowest current load
            for (Driver driver : drivers) {
                if (bestDriver == null || driver.currentLoad < bestDriver.currentLoad) {
                    bestDriver = driver;
                }
            }

        } catch (IOException e) {
            // Handle potential errors while reading the file
            System.err.println("Error reading drivers file: " + e.getMessage());
        }

        return bestDriver;  // Return the best driver found or null if none found
    }
}
