package quickFood;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CaptureOrderDetails {
  public static Order getOrderDetails(Scanner scanner, Customer customer, Restaurant restaurant) {
    Map<String, Integer> mealQuantities = new HashMap<>();
    Map<String, Double> mealPrices = new HashMap<>();

    while (true) {
      System.out.print("Enter Meal Name (or type 'done' to finish): ");
      String mealName = scanner.nextLine();
      if (mealName.equalsIgnoreCase("done"))
        break;

      System.out.print("Enter Quantity: ");
      int quantity = scanner.nextInt();
      scanner.nextLine(); // Consume newline left in buffer

      System.out.print("Enter Meal Price per unit: ");
      double price = Double.parseDouble(scanner.nextLine().replace(",", "."));

      mealQuantities.put(mealName, quantity);
      mealPrices.put(mealName, price);
    }

    System.out.print("Enter Special Instructions: ");
    String specialInstructions = scanner.nextLine();

    double totalAmount = mealQuantities.entrySet().stream()
        .mapToDouble(entry -> entry.getValue() * mealPrices.get(entry.getKey())).sum();

    return new Order(customer, restaurant, mealQuantities, mealPrices, totalAmount,
        specialInstructions);
  }
}
