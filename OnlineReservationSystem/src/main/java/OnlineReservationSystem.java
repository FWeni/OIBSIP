import com.google.gson.JsonObject;
import controller.register.UserRegistrationAPIController;
import controller.register.UserRegistrationController;
import controller.user.UserController;

import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static controller.register.UserRegistrationAPIController.registrationSuccess;
import static controller.register.UserRegistrationController.ROOT_PATH;
import static spark.Spark.*;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        port(4567);
        String staticDir = "/html";
        System.out.println("Server running on port 4567");
        try {
            staticFiles.location(staticDir);
//            configureThymeleafTemplates();
            landingPage();
            UserRegistrationController.renderRegistrationPage();
//            registrationPage();
//            get(UserRegistrationController.REGISTER, (req , res) -> new ThymeleafTemplateEngine().render(new ModelAndView(Map.of("title","Online Reservation"),"register")));
            registerUser();
            homePage();
//            UserController.renderHomepage();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    private static void configureThymeleafTemplates(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
//        templateResolver.setPrefix("/css/");
        new ThymeleafTemplateEngine(templateResolver);

    }
    private static void landingPage() {
        path(ROOT_PATH, () -> get("/",(req, res) -> "connected to server"));
    }
//    private static void registrationPage() {
//        get(UserRegistrationController.REGISTER,
//                (req , res) -> new ThymeleafTemplateEngine()
//                        .render(new ModelAndView(
//                                Map.of(
//                                        "title","Online Reservation",
//                                        "style","/css/styleRegistration.css",
//                                        "imgSrc","/assets/trainlogoNotext.png"),
//                                "register.html")));
//    }
    private static void registerUser() {
        post(UserRegistrationAPIController.API_PATH, (req, res) -> {
            String regOutput = UserRegistrationAPIController.register(req.body());
            if(!registrationSuccess){
                res.status(400);
                res.redirect(UserRegistrationController.REGISTER);
            } else {
                res.status(200);
                res.redirect(UserController.HOME_PATH);
            }
            res.type("application/json");
            return regOutput;
        });
//            get("/success", (req, res) ->
//                    new ThymeleafTemplateEngine().render(
//                            new ModelAndView(Map.of(
//                                    "title","Registration feedback",
//                                    ",message", "You have successfully registered"), "success.html")));
//    });
//        post("/submit", (req, res) -> {
//            res.header("Content-Type", "text/plain");
//
//            Map<String,Object> jsonBody = new HashMap<>();
//
//            jsonBody.put("name",req.queryParams("first_name"));
//            jsonBody.put("lastname",req.queryParams("last_name"));
//            jsonBody.put("birthdate",req.queryParams("birth_date"));
//            jsonBody.put("gender",req.queryParams("gender"));
//            jsonBody.put("email",req.queryParams("email"));
//            jsonBody.put("password",req.queryParams("password"));
//
//            String json = JsonUtil.toJson(jsonBody);
//
//            UserRegistrationAPIController.register(json);
////            System.out.println("am I getting anything :"+come);
////            if(!registrationSuccess){
////                res.status(400);
////                res.redirect(UserRegistrationController.REGISTER);
////            }else{
//            res.status(200);
//            res.redirect("/user");
////            }
//            return "";
//        });
    }
    private static void homePage() {
        get(UserController.HOME_PATH,(req,res)->{
            UserController.renderHomepage();
            return "";
        });
    }

}
