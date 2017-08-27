import org.sql2o.*;
import java.util.List;
import java.util.Date;
// Declaring my variables.
public class Appointment {
  private int id=0;
  private String time;
  private int clientid;
  private int procedureid;
// giving my variables a class and classtype..
  public Appointment (String time, int clientid, int procedureid) {
    this.time = time;
    this.clientid = clientid;
    this.procedureid = procedureid;

// Trying to make a connection to the database appointments table, and insert values into: time, clientid, procedureid.
    try(Connection cn = DB.sql2o.open()) {
    String sql = "INSERT INTO appointments (time, clientid, procedureid) VALUES (:time, :clientid, :procedureid)";
    this.id = (int) cn.createQuery(sql, true)
      .addParameter("time", this.time)
      .addParameter("clientid", this.clientid)
      .addParameter("procedureid", this.procedureid)
      .executeUpdate()
      .getKey();
  }

  }

  public int getId() {
    return id;
  }

  public String getTime() {
    return time;
  }

  public int getClientId() {
    return clientid;
  }

  public Client getClient() {
    return Client.find(clientid);
  }

  public Stylist getStylist() {
    return Stylist.find(Client.find(clientid).getStylistId());
  }

  public int getProcedureId() {
    return procedureid;
  }

  public Procedure getProcedure() {
    return Procedure.find(procedureid);
  }

//Trying to connect to the database and into the appointments table.
  public static Appointment find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM appointments WHERE id=:id";
      Appointment appointment = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Appointment.class);
      return appointment;
    }
  }
//Created a list in the database and sort them in order of time.
  public static List<Appointment> all() {
    String sql = "SELECT * FROM appointments ORDER BY time";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Appointment.class);
    }
  }
// Try connection to database and Create a delete function from the appointments table
  public static void delete(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "DELETE FROM appointments WHERE id = :id;";
      cn.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
