package controller.register;

import app.db.UseDaoImplementation;
import app.db.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import controller.user.UserController;
import spark.Request;
import spark.Response;
import util.JsonUtil;
import util.UserPasswordEncryption;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationAPIController {
    public static final String API_PATH = "/api/users";
    public static boolean registrationSuccess = false;

    public static String register(String formData) throws JsonProcessingException {
        UseDaoImplementation us = new UseDaoImplementation();
        UserPasswordEncryption encrypt = new UserPasswordEncryption();
        ObjectMapper mapper = new ObjectMapper();

        Map map = mapper.readValue(formData, Map.class);
        Map<String, Object> viewModel = new HashMap<>();

        String name = (String) map.get("first_name");
        String surname = (String) map.get("last_name");
        String birthDate = (String) map.get("birth_date");
        String gender = (String) map.get("gender");
        String email = (String) map.get("email");
        String password = (String) map.get("password");

        final User newUser = new User(name, surname, birthDate, gender, email, password);
        newUser.setFirstName(name);
        newUser.setLastName(surname);
        newUser.setBirthDate(birthDate);
        newUser.setGender(gender);
        newUser.setEmail(email);
        newUser.setPassword(encrypt.passwordEncryption(password));
        if (!name.isEmpty() ||
                !surname.isEmpty() ||
                !birthDate.isEmpty() ||
                !email.isEmpty() ||
                !password.isEmpty()) {

            us.addUser(newUser);

            viewModel = Map.of(
                    "first_name",name,
                    "last_name", surname,
                    "birth_date", birthDate,
                    "gender", gender,
                    "email", email
            );
            registrationSuccess = true;

        }
        return JsonUtil.toJson(viewModel);
    }

}
