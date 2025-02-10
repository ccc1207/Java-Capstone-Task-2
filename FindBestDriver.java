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

public class FindBestDriver {
  public static Driver findDriver(String restaurantCity) {
    Driver bestDriver = null;
    List<Driver> drivers = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("drivers-info.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] details = line.split(", ");
        if (details.length == 3) {
          String driverName = details[0].trim();
          String driverCity = details[1].trim();
          int driverLoad = Integer.parseInt(details[2].trim());

          if (driverCity.equalsIgnoreCase(restaurantCity)) {
            drivers.add(new Driver(driverName, driverCity, driverLoad));
          }
        }
      }

      // Select the driver with the lowest load
      for (Driver driver : drivers) {
        if (bestDriver == null || driver.currentLoad < bestDriver.currentLoad) {
          bestDriver = driver;
        }
      }

    } catch (IOException e) {
      System.out.println("Error reading drivers file: " + e.getMessage());
    }

    return bestDriver;
  }
}
