import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ProcedureTest {
  private Procedure procedure;
  private Procedure procedure2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "matite", "Phlipper7862");
    procedure = new Procedure("hair cut & color", 25.00f);
    procedure2 = new Procedure("women's haircut", 50.00f);
  }

  @Test
  public void Procedure_instantiates_true() {
    assertEquals(true, procedure instanceof Procedure);
  }
