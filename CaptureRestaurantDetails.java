package quickFood;

import java.util.Scanner;

/**
 * The CaptureRestaurantDetails class is responsible for capturing restaurant details from user input.
 */

public class CaptureRestaurantDetails {

    /**
     * Captures restaurant details from the console, including name, location, and contact number.
     *
     * @param scanner The Scanner object used to read user input.
     * @return A Restaurant object containing the captured details.
     */
    public static Restaurant getRestaurantDetails(Scanner scanner) {
        // Prompt the user for the restaurant's name
        System.out.print("Enter Restaurant Name: ");
        String name = scanner.nextLine().trim(); // Trim to remove leading/trailing spaces

        // Prompt the user for the restaurant's location
        System.out.print("Enter Restaurant Location: ");
        String location = scanner.nextLine().trim(); // Trim input for consistency

        // Prompt the user for the restaurant's contact number
        System.out.print("Enter Restaurant Contact Number: ");
        String contactNumber = scanner.nextLine().trim(); // Trim input to avoid formatting issues

        // Return a new Restaurant object with the provided details
        return new Restaurant(name, location, contactNumber);
    }
}
