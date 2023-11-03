package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;
import java.util.ResourceBundle;

public class logincontroller {

    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @FXML
    TextField mytextfield;
    private Stage stage;
    private Scene scene;
    private Parent root;
@FXML
    private Pane mypane3;
@FXML
    private ColorPicker mycolorpicker3;
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helloworld","root", "Chris@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

public void changecolor3(ActionEvent event3){
    Color mycolor=new Color(0.1906, 0.8696, 0.9895, 1.0);
    mypane3.setBackground(new Background(new BackgroundFill(mycolor,null,null)));
}
public void login(ActionEvent event4) throws IOException, SQLException {



    if (mytextfield.getText().isBlank() || mytextfield.getText().isEmpty()){
        System.out.println("username is empty!");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Please enter values");
        alert.show();
        return;
    }

    String username= mytextfield.getText();//we saved the text in the username container
    String emailText = email.getText();
    String passwordText = password.getText();
    String query = String.format("insert into users(username, email, passcode) value ('%s', '%s', '%s');", username, emailText, passwordText);
    con.createStatement().executeUpdate(query);

    ResultSet rs = con.createStatement().executeQuery("select * from users");
    while (rs.next()) {
        System.out.println(rs.getString("username") + " " + rs.getString("email") + " " + rs.getString("passcode"));
    }
    FXMLLoader loader=new FXMLLoader(getClass().getResource("hello-view2.fxml"));//we loaded it in the second fxml using fxml loader
    root =loader.load();//the root element

    HelloCintroller2 helloCintroller2=loader.getController();//creatin instance of the controller in this class
    helloCintroller2.displayname(username);//passin the parameter to the method in other variable

    stage=(Stage)((Node)event4.getSource()).getScene().getWindow();
    scene=new Scene(root);
    stage.setScene(scene);
    stage.setTitle("THE HOME PAGE");
    stage.show();
}

}
