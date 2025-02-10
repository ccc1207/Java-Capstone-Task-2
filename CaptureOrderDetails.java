package quickFood;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The CaptureOrderDetails class handles capturing order details from user input.
 */
public class CaptureOrderDetails {

    /**
     * Captures order details from the console, including meals, quantities, prices, and special instructions.
     *
     * @param scanner    The Scanner object used to read user input.
     * @param customer   The Customer placing the order.
     * @param restaurant The Restaurant from which the order is being placed.
     * @return An Order object containing the captured details.
     */
    public static Order getOrderDetails(Scanner scanner, Customer customer, Restaurant restaurant) {
        // Map to store meal names and their respective quantities
        Map<String, Integer> mealQuantities = new HashMap<>();

        // Map to store meal names and their respective prices per unit
        Map<String, Double> mealPrices = new HashMap<>();

        // Loop to capture multiple meals until the user decides to stop
        while (true) {
            System.out.print("Enter Meal Name (or type 'done' to finish): ");
            String mealName = scanner.nextLine();

            // Check if the user is finished entering meals
            if (mealName.equalsIgnoreCase("done")) {
                break;
            }

            // Prompt the user for the quantity of the meal
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left in the input buffer

            // Prompt the user for the price per unit of the meal
            System.out.print("Enter Meal Price per unit: ");
            double price = Double.parseDouble(scanner.nextLine().replace(",", ".")); // Convert input to double

            // Store the meal name, quantity, and price in respective maps
            mealQuantities.put(mealName, quantity);
            mealPrices.put(mealName, price);
        }

        // Prompt the user for any special instructions regarding the order
        System.out.print("Enter Special Instructions: ");
        String specialInstructions = scanner.nextLine();

        // Calculate the total order amount by multiplying quantity and price for each meal
        double totalAmount = mealQuantities.entrySet().stream()
            .mapToDouble(entry -> entry.getValue() * mealPrices.get(entry.getKey()))
            .sum();

        // Return a new Order object with all captured details
        return new Order(customer, restaurant, mealQuantities, mealPrices, totalAmount, specialInstructions);
    }
}
