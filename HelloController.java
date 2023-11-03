package com.example.helloworld;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import java.util.spi.ResourceBundleControlProvider;

import static javafx.scene.paint.Color.color;

public class HelloController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Pane mypane;
    @FXML
    private ColorPicker myColorpicker;
    @FXML
    ImageView myimage2;
    @FXML
    private Slider myslider1;
    @FXML
    private Label lb3;
    int mytemperature;
    @FXML
    ImageView myimage3;

    @FXML
    Button bt4;
    @FXML
    Button bt6;




    public void myimage3(ActionEvent e) {
        Image img = new Image(getClass().getResourceAsStream("png-image.png"));
    }

    public void initialize(URL arg0, ResourceBundle args1) {


        myslider1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                mytemperature = (int) myslider1.getValue();
                lb3.setText(Integer.toString(mytemperature) + "°C");
            }
        });
    }


    public void onSliderChange() {
        int value = (int)myslider1.getValue();
        System.out.println("the value is =" + value);

        int multiplier = 30;
        if (value <20 ) {
            multiplier*=2;
        }
        int speed = 100+ multiplier*(30-value);
        System.out.println(speed);


        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myimage3);
        rotate.setDuration(Duration.millis(speed));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();


    }

        Image image2 =new Image(getClass().getResourceAsStream("powerbutton2.png"));

    //Image imgg= new Image(getClass().getResourceAsStream("poweronbutton2.jpg"));
//public void displayimage1() {
//yimage2.setImage(imgg);
//}

    public void changecolor(ActionEvent event1) {

        Color myColor = new Color(0.1906, 0.8696, 0.9895, 1.0);

        mypane.setBackground(new Background(new BackgroundFill(myColor, null, null)));

    }





    public void switchetoscene1(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("maininterface.fxml"));
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        stage.setTitle("THE MAIN REMOTE");
        this.stage.show();

    }
    public void switchoff(ActionEvent eventt)throws IOException{
        Parent root  =(Parent) FXMLLoader.load(this.getClass().getResource("hello-view2.fxml"));
        this.stage =(Stage) ((Node)eventt.getSource()).getScene().getWindow();
        this.scene=new Scene(root);
        this.stage.setScene(this.scene);
        stage.setTitle("THE HOME PAGE");
        this.stage.show();
    }
}

