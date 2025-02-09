package quickFood;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class GenerateInvoice {
  public static void createInvoice(Order order, Driver driver) {
    DecimalFormat df = new DecimalFormat("0.00");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("invoice.txt"))) {
      writer.write("Order Number: " + order.customer.orderNumber + "\n");
      writer.write("Customer: " + order.customer.name + "\n");
      writer.write("Email: " + order.customer.email + "\n");
      writer.write("Phone number: " + order.customer.contactNumber + "\n");
      writer.write("Location: " + order.customer.city + "\n\n");

      writer.write("You have ordered the following from " + order.restaurant.name + " in "
          + order.restaurant.city + ":\n");

      for (String meal : order.mealQuantities.keySet()) {
        int quantity = order.mealQuantities.get(meal);
        double price = order.mealPrices.get(meal);
        writer.write(String.format("%d x %s (R%s each) - Total: R%s%n", quantity, meal,
            df.format(price), df.format(quantity * price)));
      }

      writer.write("Special instructions: " + order.specialInstructions + "\n");
      writer.write(String.format("Total: R%s%n%n", df.format(order.totalAmount)));

      if (driver != null) {
        writer.write(
            driver.name + " is nearest to the restaurant and will be delivering your order to: \n");
        writer.write(order.customer.city + "\n\n");
      } else {
        writer.write(
            "Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
      }

      writer.write("If you need to contact the restaurant, their number is "
          + order.restaurant.contactNumber + ".\n");
    } catch (IOException e) {
      System.out.println("Error writing invoice file.");
    }
  }
}
