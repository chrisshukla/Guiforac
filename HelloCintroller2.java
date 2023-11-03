package com.example.helloworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloCintroller2 {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Pane mypane2;
    @FXML
    private ColorPicker myColorpicker2;
    @FXML
    ImageView myimage;
    @FXML
    Label mylb;

    public void displayname(String username){
        mylb.setText("Welcome: "+ username +" to the GUI of ChillAir");
    }

    Image myimg = new Image(getClass().getResourceAsStream("logo.png"));//the image loading
    public void displayimage(ActionEvent event2){
        myimage.setImage(myimg);

    }


    public void changecolor2(ActionEvent event1){

        Color myColor=new Color(0.1906, 0.8696, 0.9895, 1.0);
        mypane2.setBackground(new Background(new BackgroundFill(myColor,null,null)));

    }
    public void switchetoscene2(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("hello-view.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        stage.setTitle("THE DEFAULT REMOTE");
        this.stage.show();
    }}

