import org.sql2o.*;
import java.util.List;
// Declaring my variable class names
public class Procedure {
  private int id=0;
  private String description;
  private float price;
// Assigning a class and a class-type to my variables
  public Procedure(String description, float price) {
    this.description=description;
    this.price=price;
//Trying to Establish a connection to the database procedures table and insert values into the description and price column.
    try(Connection cn = DB.sql2o.open()) {
    String sql = "INSERT INTO procedures (description, price) VALUES (:description, :price)";
    this.id = (int) cn.createQuery(sql, true)
      .addParameter("description", this.description)
      .addParameter("price", this.price)
      .executeUpdate()
      .getKey();
  }
}
// Using the get() method to fetch information Procedure class.
public int getId() {
  return id;
}

public String getDescription() {
  return description;
}
// Tring to make a connection to the database procedures table and using the set method set the description column using specific id.
public void setDescription(String description) {
  this.description=description;
  try(Connection cn = DB.sql2o.open()) {
    String sql = "UPDATE procedures SET description = :description WHERE id = :id";
    cn.createQuery(sql)
      .addParameter("description", description)
      .addParameter("id", id)
      .executeUpdate();
  }
}
// Using the get() to fetcch info from the Procedure class.
public float getPrice() {
  return price;
}

// Using set() we try to make a connection to the database procedures table, and update value in the price column using its specific id.
public void setPrice(float price) {
  this.price=price;
  try(Connection cn = DB.sql2o.open()) {
    String sql = "UPDATE procedures SET price = :price WHERE id = :id";
    cn.createQuery(sql)
      .addParameter("price", price)
      .addParameter("id", id)
      .executeUpdate();
  }
}

}
