package quickFood;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickFood {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Capture customer details
      Customer customer = CaptureCustomerDetails.getCustomerDetails(scanner);

      // Capture restaurant details
      Restaurant restaurant = CaptureRestaurantDetails.getRestaurantDetails(scanner);

      // Validate location: Restaurant and Customer must be in the same city
      if (!customer.getCity().equalsIgnoreCase(restaurant.getCity())) {
        System.out
            .println("The restaurant is too far from your city. Your order cannot be delivered.");
        return;
      }

      // Capture order details
      Order order = CaptureOrderDetails.getOrderDetails(scanner, customer, restaurant);

      // Find best driver based on restaurant's city
      Driver assignedDriver = FindBestDriver.findDriver(restaurant.getCity());

      if (assignedDriver != null) {
        // Generate invoice if a driver is assigned
        GenerateInvoice.createInvoice(order, assignedDriver);
        System.out.println("Invoice generated as 'invoice.txt'.");
      } else {
        System.out.println("No driver available for this order.");
      }

    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please enter the correct values.");
    } catch (Exception e) {
      System.out.println("An unexpected error occurred: " + e.getMessage());
    } finally {
      scanner.close(); // Ensure scanner is always closed
    }
  }
}
