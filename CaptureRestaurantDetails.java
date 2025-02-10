package quickFood;

import java.util.Scanner;

/**
 * The CaptureRestaurantDetails class is responsible for capturing restaurant details from user input.
 */

public class CaptureRestaurantDetails {
  public static Restaurant getRestaurantDetails(Scanner scanner) {
    System.out.print("Enter Restaurant Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Restaurant Location: ");
    String location = scanner.nextLine();
    System.out.print("Enter Restaurant Contact Number: ");
    String contactNumber = scanner.nextLine();

    return new Restaurant(name, location, contactNumber);
  }
}

