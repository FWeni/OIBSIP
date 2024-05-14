package controller.user;

import app.db.UseDaoImplementation;
import app.db.model.User;


import com.fasterxml.jackson.databind.*;
import org.json.JSONObject;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import util.JsonUtil;
import util.TemplateRender;
import util.UserPasswordEncryption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class UserController {
    public static final String HOME_PATH = "/home";
    public static final String USER_API = "/api/users/user";
    public static final String BOOK_TRIP = "/booking";
    public static final String CANCEL_TRIP = "/cancel";

    UseDaoImplementation us = new UseDaoImplementation();
    UserPasswordEncryption encrypt = new UserPasswordEncryption();
    String incomingData;
    JSONObject jsonObject;
    String apiResponse;


    public static void renderHomepage() {
       get(HOME_PATH, (req, res) ->
               new ThymeleafTemplateEngine()
                       .render(new ModelAndView
                               (makeViewModel(),"user.html")
                       ));
    }
    public static Map<String, Object> makeViewModel() {
        User user = new User();

        Map<String,Object> viewModel = new HashMap<>();
        Map<String,Object> userDetails = new HashMap<>();
        Map<String,Object> userInterface = new HashMap<>();

        userDetails.put("name",user.getFirstName());
        userDetails.put("lastname",user.getLastName());
        userDetails.put("birthdate", user.getBirthDate());
        userDetails.put("gender",user.getGender());
        userDetails.put("email", user.getEmail());
        userInterface.put("areaImg","/assets/south-africa.png");
        userInterface.put("style","/css/style.css");
        userInterface.put("js","/js/index.js");
        viewModel.put("user", userDetails);
        viewModel.put("ui",userInterface);
        System.out.println(viewModel);
        return viewModel;
    }

    private void getUser() {
        get(USER_API, (req,res) -> {
            incomingData = req.body();
            jsonObject = new JSONObject(incomingData);

            List<User> allUsers = us.getAllUsers();


            String providedPsw = jsonObject.getString("password");
            String providedEmail = jsonObject.getString("email");

            for (User obj : allUsers) {
                jsonObject = new JSONObject(obj);
                String oneUserEmail = jsonObject.getString("email");
                String psw = jsonObject.getString("password");

                int userId = obj.getId();

                if (oneUserEmail.equals(providedEmail) && psw.equals(encrypt.passwordEncryption(providedPsw))) {
                    res.status(200);
                    apiResponse = String.valueOf(us.getUserById(userId));
                } else {
                    res.status(400);
                    apiResponse = "Incorrect user email or password";
                }

            }
            return apiResponse;
        });
    }
//
//    public void getUsers() {
//        get("api/users", (req,res) -> {
////            incomingData = req.body();
////            jsonObject = new JSONObject(incomingData);
////            String users = jsonObject.getString("users");
//            List<User> users = us.getAllUsers();
//
//            if (users.isEmpty()) {
//                res.status(400);
//                apiResponse = "could not perform action.";
//            } else {
//                res.status(200);
//                apiResponse = us.getAllUsers().toString();
//
//            }
//            return apiResponse;
//        });
//    }


}

