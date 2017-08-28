import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  private Client client;
  private Client client2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "matite", "Phlipper7862");
    client = new Client("Tom", "Braidy", "254-721-7623", "tombraidy89@gmail.com", 20, 1);
    client2 = new Client("Christine", "Lompoi", "254-721-7623", "Ngong Lane", "lompoit67@gmail.com", 20, 1);
  }

  @Test
  public void Client_instantiates_true() {
    assertEquals(true, client instanceof Client);
  }
