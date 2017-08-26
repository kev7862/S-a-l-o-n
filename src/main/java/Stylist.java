import org.sql2o.*;
import java.util.List;

// Declaring the variable
public class Stylist {
  private String name;
  private int id=0;
//setting the variable into a class
  public Stylist(String name) {
    this.name=name;
// trying to make a connection into the database stylists table and insert value into the name column.
    try(Connection cn = DB.sql2o.open()) {
    String sql = "INSERT INTO stylists (name) VALUES (:name)";
    this.id = (int) cn.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
  }
  }

  public int getId() {
  return id;
}

public String getName() {
  return name;
}
}
