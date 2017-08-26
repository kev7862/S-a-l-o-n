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
// Using the find() We're trying to connect to the database stylist table and display everything with an id
  public static Stylist find(int id) {
  try(Connection cn = DB.sql2o.open()) {
    String sql = "SELECT * FROM stylists WHERE id=:id";
    Stylist stylist = cn.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
    return stylist;

}
 //We're creatin a List, using the all() we try to make a connection to database stylists table and display data in order of name.

public static List<Stylist> all() {
    String sql = "SELECT * FROM stylists ORDER BY name";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

// Using the delete(), We try to Establish a connection to database stylists table and delete any field with a specific id.
  public static void delete(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists WHERE id = :id;";
      cn.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
