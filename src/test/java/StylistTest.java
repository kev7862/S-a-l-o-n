import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  private Stylist stylist;
  private Stylist stylist2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "matite", "Phlipper7862");
    stylist = new Stylist("Cheryl");
    stylist2 = new Stylist("Cheryl");
  }

  @Test
  public void Stylist_instantiates_true() {
    assertEquals(true, stylist instanceof Stylist);
  }
