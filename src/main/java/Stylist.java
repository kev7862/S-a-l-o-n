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

//  Trying to make connection to stylists database table and fetch name by id.
  public void setName(String name) {
    this.name=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET name = :name WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
}
