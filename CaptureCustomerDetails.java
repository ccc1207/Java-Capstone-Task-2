package quickFood;

import java.util.Scanner;

public class CaptureCustomerDetails {
  public static Customer getCustomerDetails(Scanner scanner) {
    System.out.print("Enter Order Number: ");
    String orderNumber = scanner.nextLine();
    System.out.print("Enter Customer Name: ");
    String customerName = scanner.nextLine();
    System.out.print("Enter Contact Number: ");
    String contactNumber = scanner.nextLine();
    System.out.print("Enter Address: ");
    String address = scanner.nextLine();
    System.out.print("Enter City: ");
    String city = scanner.nextLine();
    System.out.print("Enter Email: ");
    String email = scanner.nextLine();

    return new Customer(orderNumber, customerName, contactNumber, address, city, email);
  }
}
