import org.sql2o.*;
import java.util.List;
// Declaring my variable class names
public class Procedure {
  private int id=0;
  private String description;
  private float price;
// Assigning a class and a class-type to my variables
  public Procedure(String description, float price) {
    this.description=description;
    this.price=price;
