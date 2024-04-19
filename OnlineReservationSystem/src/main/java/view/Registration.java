package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class Registration extends Application {
    @Override
    public void start(Stage stage) {
        Text nameTag = new Text("Name");
        TextField nameText = new TextField();

        Text lastNameTag = new Text("Last Name");
        TextField lastNameText = new TextField();

        Text securityNumberTag = new Text("Social Security No");
        TextField securityNumber = new TextField();

        Text dobTag = new Text("Date of birth");
        DatePicker datePicker = new DatePicker();

        Text genderTag = new Text("Gender");
        ToggleGroup genderTagGroup = new ToggleGroup();
        RadioButton maleBtn = new RadioButton("male");
        maleBtn.setToggleGroup(genderTagGroup);

        RadioButton femaleBtn = new RadioButton("female");
        femaleBtn.setToggleGroup(genderTagGroup);

        RadioButton genderFluidBtn = new RadioButton("other");
        genderFluidBtn.setToggleGroup(genderTagGroup);

        Text passwordTag = new Text("Password");
        TextField password = new TextField();

        Text confirmPasswordTag = new Text("Confirm Password");
        TextField ConfirmPassword = new TextField();

        Button registerBtn = new Button("Register");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(nameTag,0,0);
        gridPane.add(nameText, 1, 0);
//        gridPane.addRow(0, nameTag,nameText);

    }
}
