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
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<CD> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<CD>();
      }

      String artist = request.queryParams("inputArtist");
      String title = request.queryParams("inputTitle");
      CD newCd = new CD(artist, title);
      cds.add(newCd);
      System.out.println(cds.size() + " " + cds.get(0).getArtist());

      model.put("cds", cds);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
