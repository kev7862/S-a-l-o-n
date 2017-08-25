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


  }
}
