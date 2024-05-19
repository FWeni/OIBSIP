package controller.user;

import app.db.UseDaoImplementation;
import app.db.model.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import controller.register.UserRegistrationAPIController;
import org.json.JSONObject;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import util.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class UserController {
    public static final String HOME_PATH = "/home";
    public static final String USER_API = "/api/users/user";
    public static final String BOOK_TRIP = "/booking";
    public static final String CANCEL_TRIP = "/cancel";

    static JSONObject jsonObject;
    static UseDaoImplementation userDao;
    static ObjectMapper mapper = new ObjectMapper();

    public static String userFromDB() {
        Map<String,Object> userDetails = new HashMap<>();
        get(USER_API, (req, res) -> {

           List<User> allCurrentUsers = userDao.getAllUsers();
           System.out.println(allCurrentUsers);

           Map map = mapper.readValue(req.body(), Map.class);

           String submittedPsw = (String) map.get("password");
           String submittedEmail = (String) map.get("email");


           Map<String,Object> serverRes = new HashMap<>();

           String userFound = "";

           for (User user: allCurrentUsers) {
               Map userMapping = mapper.readValue(user.toString(),Map.class);
//               jsonObject = new JSONObject(user);

//               String existingPsw = jsonObject.getString("password");
//               String existingEmail = jsonObject.getString("email");
               String existingEmail = (String) userMapping.get("email");
               String existingPsw = (String) userMapping.get("password");
               int userId;

               if (existingEmail.equals(submittedEmail) && existingPsw.equals(submittedPsw)) {
//                   userId = jsonObject.getInt("id");
                   userId = (int) userMapping.get("id");
                   userFound = JsonUtil.toJson(userDao.getUserById(userId));
                   res.status(200);
                   serverRes.put("message","User found.");
               } else {
                   res.status(402);
                   serverRes.put("message","User not found.");
               }
           }
//           jsonObject = new JSONObject(userFound);
//           System.out.println(jsonObject.getString("name"));
//           userDetails.put("name", jsonObject.getString("name"));
//           userDetails.put("lastname", jsonObject.getString("lastname"));
//           userDetails.put("gender", jsonObject.getString("gender"));
//           userDetails.put("email", jsonObject.getString("email"));
//           userDetails.put("dob", jsonObject.getString("birthdate"));
            Map mapData = mapper.readValue(userFound,Map.class);
            System.out.println(mapData.get("name"));
            userDetails.put("name", mapData.get("name"));
            userDetails.put("lastname", mapData.get("lastname"));
            userDetails.put("gender", mapData.get("gender"));
            userDetails.put("email", mapData.get("email"));
            userDetails.put("dob", mapData.get("birthdate"));
            return JsonUtil.toJson(serverRes);
       });
       return JsonUtil.toJson(userDetails);
    }
    public static Map<String, Object> makeViewModel() {
        return Map.of(
                "areaImg","/assets/south-africa.png",
                "navLogo","/assets/trainlogoNotext.png",
                "style","/css/style.css",
                "user-js", "/js/user.js",
                "index-js","/js/index.js");
    }

    public static void renderUserHomePage() {
        get(HOME_PATH, (req , res) -> new ThymeleafTemplateEngine()
                .render(new ModelAndView(
                        makeViewModel(),
                        "user.html")));
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

