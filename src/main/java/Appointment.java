import org.sql2o.*;
import java.util.List;
import java.util.Date;

public class Appointment {
  private int id=0;
  private String time;
  private int clientid;
  private int procedureid;

  public Appointment (String time, int clientid, int procedureid) {
    this.time = time;
    this.clientid = clientid;
    this.procedureid = procedureid;

// Trying to connect to the database.
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

  public static List<Appointment> all() {
    String sql = "SELECT * FROM appointments ORDER BY time";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Appointment.class);
    }
  }

}
