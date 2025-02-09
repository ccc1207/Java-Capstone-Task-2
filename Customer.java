package quickFood;

public class Customer {
  public String orderNumber;
  public String name;
  public String contactNumber;
  public String address;
  public String city;
  public String email;

  // Constructor with 6 parameters
  public Customer(String orderNumber, String name, String contactNumber, String address,
      String city, String email) {
    this.orderNumber = orderNumber;
    this.name = name;
    this.contactNumber = contactNumber;
    this.address = address;
    this.city = city;
    this.email = email;
  }

  // Getter for orderNumber
  public String getOrderNumber() {
    return orderNumber;
  }

  // Getter for name
  public String getName() {
    return name;
  }

  // Getter for contactNumber
  public String getContactNumber() {
    return contactNumber;
  }

  // Getter for address
  public String getAddress() {
    return address;
  }

  // Getter for city
  public String getCity() {
    return city;
  }

  // Getter for email
  public String getEmail() {
    return email;
  }
}
