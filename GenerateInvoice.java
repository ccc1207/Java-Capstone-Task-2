package quickFood;

import java.io.BufferedWriter;

/**
 * The GenerateInvoice class is responsible for generating a customer invoice 
 * and saving it to a text file.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * The GenerateInvoice class is responsible for generating a customer invoice 
 * and saving it to a text file.
 */

public class GenerateInvoice {

    /**
     * Creates an invoice based on the customer's order and the assigned driver.
     *
     * @param order  The Order object containing customer, restaurant, and order details.
     * @param driver The assigned Driver object for delivery (can be null if no driver is found).
     */
    public static void createInvoice(Order order, Driver driver) {
        // Decimal formatter to ensure consistent currency formatting (e.g., R12.00)
        DecimalFormat df = new DecimalFormat("0.00");

        // Try-with-resources ensures the BufferedWriter is properly closed after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("invoice.txt"))) {
            
            // Write customer details
            writer.write("Order Number: " + order.customer.orderNumber + "\n");
            writer.write("Customer: " + order.customer.name + "\n");
            writer.write("Email: " + order.customer.email + "\n");
            writer.write("Phone number: " + order.customer.contactNumber + "\n");
            writer.write("Location: " + order.customer.city + "\n\n");

            // Write restaurant details and order summary
            writer.write("You have ordered the following from " + order.restaurant.name + 
                         " in " + order.restaurant.city + ":\n");

            // Loop through each meal in the order and write details
            for (String meal : order.mealQuantities.keySet()) {
                int quantity = order.mealQuantities.get(meal);
                double price = order.mealPrices.get(meal);
                writer.write(String.format("%d x %s (R%s each) - Total: R%s%n", 
                             quantity, meal, df.format(price), df.format(quantity * price)));
            }

            // Write special instructions if provided
            writer.write("Special instructions: " + order.specialInstructions + "\n");

            // Write the total amount payable
            writer.write(String.format("Total: R%s%n%n", df.format(order.totalAmount)));

            // Check if a driver is available and write delivery details
            if (driver != null) {
                writer.write(driver.name + " is nearest to the restaurant and will be delivering your order to: \n");
                writer.write(order.customer.city + "\n\n");
            } else {
                writer.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
            }

            // Provide restaurant contact details
            writer.write("If you need to contact the restaurant, their number is " 
                         + order.restaurant.contactNumber + ".\n");

        } catch (IOException e) {
            System.out.println("Error writing invoice file: " + e.getMessage());
        }
    }
}
