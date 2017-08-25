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


}
