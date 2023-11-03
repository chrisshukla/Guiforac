package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class login2controller {

    private Stage stage;
    private Scene scene;
    @FXML
    TextField namefield;
    @FXML
    TextField emailfield;
    @FXML
    PasswordField passwordfield;
    @FXML
    Button Button4;

    @FXML
    Hyperlink regis;
    static Connection con;


    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helloworld", "root", "Chris@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void OnbuttonCLick(ActionEvent event) throws IOException, SQLException {



        String query = String.format("select * from users where username='%s';", namefield.getText());
        ResultSet rs = con.createStatement().executeQuery(query);
        String retrivedname = new String(), retrivedemail = new String(), retrivedpass = new String();
        while (rs.next()) {
            retrivedname = rs.getString("username");
            retrivedemail = rs.getString("email");
            retrivedpass = rs.getString("passcode");
            break;
        }

        System.out.println(namefield.getText() + retrivedname);

            if (namefield.getText().isBlank() || namefield.getText().isEmpty()){
                System.out.println("username is empty!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter values");
                alert.show();
                return;
            }
        
            if (namefield.getText().equals(retrivedname)) {
                if (emailfield.getText().equals(retrivedemail)) {
                    if (passwordfield.getText().equals(retrivedpass)) {
                        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("hello-view2.fxml"));
                        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        this.scene = new Scene(root);
                        this.stage.setScene(this.scene);
                        stage.setTitle("THE HOME PAGE");
                        this.stage.show();

                    }
                }
            }


         else {
            System.out.println("invalid username or password");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("invalid username or password");
            alert.show();
        }
    }

    public void OnRegistration(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("login.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        stage.setTitle("THE REGISTRATION PAGE");
        this.stage.show();
    }
}





