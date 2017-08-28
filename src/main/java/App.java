import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("appointents", Appointment.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Stylist stylist = new Stylist(request.queryParams("stylist"));
    model.put("stylist", stylist.getName());
    model.put("stylists", Stylist.all());
    model.put("template", "templates/stylist.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/stylist", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("stylists", Stylist.all());
    model.put("template", "templates/stylists.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/stylists", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    int id = Integer.parseInt(request.params(":id"));
    model.put("stylist", Stylist.find(id));
    model.put("clients", Client.allByStylist(id));
    model.put("template", "templates/stylist.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/stylists/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    int id = Integer.parseInt(request.params(":id"));
    Stylist.find(id).setName(request.queryParams("first"));
    model.put("stylist", Stylist.find(id));
    model.put("clients", Client.allByStylist(id));
    model.put("template", "templates/stylists.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/clients", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Client client = new Client(
    request.queryParams("first"),
    request.queryParams("last"),
    request.queryParams("phone"),
    request.queryParams("email"),
    Integer.parseInt(request.queryParams("age")),
    Integer.parseInt(request.queryParams("stylist"))
  );
  model.put("first", client.getFirstName());
  model.put("last", client.getLastName());
  model.put("phone", client.getPhoneNumber());
  model.put("email", client.getEmail());
  model.put("age", client.getAge());
  model.put("clients", Client.all());
  model.put("template", "templates/client.vtl");
  model.put("stylists", Stylist.all());
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

get("/client", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("clients", Client.all());
  model.put("stylists", Stylist.all());
  model.put("template", "templates/clients.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

  }
}
