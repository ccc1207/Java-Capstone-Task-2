package quickFood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
  String name, location;
  int currentLoad;

  public Driver(String name, String location, int currentLoad) {
    this.name = name;
    this.location = location;
    this.currentLoad = currentLoad;
  }

  // Method to read drivers from the file
  public static List<Driver> loadDrivers(String filename) {
    List<Driver> drivers = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] details = line.split(", ");
        if (details.length == 3) {
          String name = details[0].trim();
          String location = details[1].trim();
          int load = Integer.parseInt(details[2].trim());

          drivers.add(new Driver(name, location, load));
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading the drivers file: " + e.getMessage());
    }

    return drivers;
  }

  public static Driver findBestDriver(String restaurantCity, String customerCity,
      List<Driver> drivers) {
    if (!restaurantCity.trim().equalsIgnoreCase(customerCity.trim())) {
      // If restaurant and customer cities do not match, show the error message
      System.out.println(
          "Sorry! Our drivers are too far away from you to be able to deliver to your location.");
      return null; // No driver will be assigned
    }

    Driver bestDriver = null;

    // If cities match, find the driver in the restaurant city
    for (Driver driver : drivers) {
      if (driver.location.trim().equalsIgnoreCase(restaurantCity.trim())) {
        if (bestDriver == null || driver.currentLoad < bestDriver.currentLoad) {
          bestDriver = driver;
        }
      }
    }

    if (bestDriver == null) {
      System.out.println("Sorry! No available drivers in " + restaurantCity.trim());
    } else {
      System.out.println("Best driver chosen: " + bestDriver.name);
    }

    return bestDriver;
  }
}
