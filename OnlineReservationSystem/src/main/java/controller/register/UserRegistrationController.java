package controller.register;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import java.util.Map;

import static spark.Spark.get;

public class UserRegistrationController {
    public static final String REGISTER = "/register";
    public static final String ROOT_PATH = "/index.html";

    public static void renderRegistrationPage() {
        get(REGISTER, (req , res) -> new ThymeleafTemplateEngine()
                .render(new ModelAndView(
                        Map.of(
                                "title","Online Reservation",
                                "style","/css/styleRegistration.css",
                                "imgSrc","/assets/trainlogoNotext.png"),
                                "register.html")));
    }

}
