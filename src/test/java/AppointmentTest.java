import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AppointmentTest {
  private Appointment appointment;
  private Appointment appointment2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "matite", "Phlipper7862");
    appointment = new Appointment("2017-10-19 10:00:00", 1, 1);
    appointment2 = new Appointment("2017-01-19 9:00:00", 1, 1);
  }

  @Test
  public void Appointment_instantiates_true() {
    assertEquals(true, appointment instanceof Appointment);
  }
