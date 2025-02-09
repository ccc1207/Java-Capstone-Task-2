package quickFood;

import java.util.Map;

public class Order {
  Customer customer;
  Restaurant restaurant;
  Map<String, Integer> mealQuantities;
  Map<String, Double> mealPrices;
  double totalAmount;
  String specialInstructions;

  public Order(Customer customer, Restaurant restaurant, Map<String, Integer> mealQuantities,
      Map<String, Double> mealPrices, double totalAmount, String specialInstructions) {
    this.customer = customer;
    this.restaurant = restaurant;
    this.mealQuantities = mealQuantities;
    this.mealPrices = mealPrices;
    this.totalAmount = totalAmount;
    this.specialInstructions = specialInstructions;
  }
}
