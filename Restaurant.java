package quickFood;


public class Restaurant {
  String name, city, contactNumber;

  public Restaurant(String name, String city, String contactNumber) {
    this.name = name;
    this.city = city;
    this.contactNumber = contactNumber;
  }

  // Getter for name
  public String getName() {
    return name;
  }

  // Getter for city
  public String getCity() {
    return city;
  }

  // Getter for contactNumber
  public String getContactNumber() {
    return contactNumber;
  }
}
