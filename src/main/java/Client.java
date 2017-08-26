import org.sql2o.*;
import java.util.List;

public class Client {
  private int id=0;
  private int stylistid=0;
  private String firstname;
  private String lastname;
  private String phonenumber;
  private String email;
  private int age;

  public Client(String firstname, String lastname, String phone, String email, int age, int stylistid) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.age = age;
    this.phonenumber = phonenumber;
    this.stylistid = stylistid;

// Trying to Establish a connection into the database clients table and insert parameters then update.
    try(Connection cn = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (firstname, lastname, phonenumber, email, age, stylistid) VALUES (:firstname, :lastname, :phonenumber, :email, :age, :stylistid)";
      this.id = (int) cn.createQuery(sql, true)
        .addParameter("lastname", this.lastname)
        .addParameter("firstname", this.firstname)
        .addParameter("phonenumber", this.phonenumber)
        .addParameter("email", this.email)
        .addParameter("age", this.age)
        .addParameter("stylistid", this.stylistid)
        .executeUpdate()
        .getKey();
    }

  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstname;
  }

  public String getLastName() {
    return lastname;
  }

  public String getPhoneNumber() {
    return phonenumber;
  }

  public String getEmail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  public int getStylistId() {
    return stylistid;
  }

// Trying to Establish a connection to the database and update the clients first name by id.
  public void setFirstName(String name) {
    this.firstname=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET firstname = :firstname WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("firstname", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
// Trying to Establish a connection into the database clients table and set and updates last name by id.
  public void setLastName(String name) {
  this.lastname=name;
  try(Connection cn = DB.sql2o.open()) {
    String sql = "UPDATE clients SET lastname = :lastname WHERE id = :id";
    cn.createQuery(sql)
      .addParameter("lastname", name)
      .addParameter("id", id)
      .executeUpdate();
  }
}

//Trying to Establish a connection into database clients table and set phone number by id.
public void setPhoneNumber(String phone) {
    this.phonenumber=phone;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET phonenumber = :phonenumber WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("phonenumber", phone)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

// Trying to Establish a connection to database clients table and setEmail by id
  public void setEmail(String email) {
    this.email=email;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET email = :email WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("email", email)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

// Trying to Establish a connection to database clients table and set age by id
  public void setAge(int age) {
    this.age=age;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET age = :age WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("age", age)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public static Client find(int id) {
  try(Connection cn = DB.sql2o.open()) {
    String sql = "SELECT * FROM clients WHERE id=:id";
    Client client = cn.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
    return client;
  }
}

// Establishing connection to database clients table then Creating a client list
public static List<Client> allByStylist(int id) {
  String sql = "SELECT * FROM clients WHERE stylistid = :id ORDER BY lastname, firstname, age";
  try(Connection cn = DB.sql2o.open()) {
    return cn.createQuery(sql)
    .addParameter("id", id)
    .executeAndFetch(Client.class);
  }
}

public static List<Client> all() {
  String sql = "SELECT * FROM clients ORDER BY lastname, firstname, age";
  try(Connection cn = DB.sql2o.open()) {
    return cn.createQuery(sql).executeAndFetch(Client.class);
  }
}

public static void delete(int id) {
  try(Connection cn = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
    cn.createQuery(sql)
    .addParameter("id", id)
    .executeUpdate();
  }
}

}
