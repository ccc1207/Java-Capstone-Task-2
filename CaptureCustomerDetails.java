package quickFood;

import java.util.Scanner;

/**
 * The CaptureCustomerDetails class handles capturing customer details from user input.
 */
public class CaptureCustomerDetails {

    /**
     * Captures customer details from the console using a Scanner.
     *
     * @param scanner The Scanner object used to read user input.
     * @return A Customer object containing the captured details.
     */
    public static Customer getCustomerDetails(Scanner scanner) {
        // Prompt the user to enter their order number
        System.out.print("Enter Order Number: ");
        String orderNumber = scanner.nextLine();

        // Prompt the user to enter their full name
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        // Prompt the user to enter their contact number
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        // Prompt the user to enter their address
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        // Prompt the user to enter their city
        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        // Prompt the user to enter their email address
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Return a new Customer object initialized with the provided details
        return new Customer(orderNumber, customerName, contactNumber, address, city, email);
    }
}
