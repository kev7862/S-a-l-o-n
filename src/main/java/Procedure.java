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
