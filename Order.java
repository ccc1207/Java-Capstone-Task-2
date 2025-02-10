package quickFood;

import java.util.Map;

/**
 * Represents a customer's order, including details about the customer, 
 * restaurant, ordered meals, total amount, and any special instructions.
 */
public class Order {
  public Customer customer;               // Customer placing the order
  public Restaurant restaurant;           // Restaurant fulfilling the order
  public Map<String, Integer> mealQuantities; // Meal names with their quantities
  public Map<String, Double> mealPrices;      // Meal names with their prices per unit
  public double totalAmount;              // Total cost of the order
  public String specialInstructions;      // Any special instructions for the order
  
  public Order(Customer customer, Restaurant restaurant, 
      Map<String, Integer> mealQuantities, Map<String, Double> mealPrices, 
      double totalAmount, String specialInstructions) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.mealQuantities = mealQuantities;
        this.mealPrices = mealPrices;
        this.totalAmount = totalAmount;
        this.specialInstructions = specialInstructions;
    }

    // Getter methods for encapsulation

    public Customer getCustomer() {
      return customer;
    }

    public Restaurant getRestaurant() {
      return restaurant;
    }

    public Map<String, Integer> getMealQuantities() {
      return mealQuantities;
    }

    public Map<String, Double> getMealPrices() {
      return mealPrices;
    }

    public double getTotalAmount() {
      return totalAmount;
    }

    public String getSpecialInstructions() {
      return specialInstructions;
    }
}
