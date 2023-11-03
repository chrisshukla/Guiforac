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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.color;

public class HelloController3 implements Initializable {
@FXML
private Slider myslide4;
@FXML
private AnchorPane background;
    @FXML
    private Slider myslide3;
    @FXML
            private Label lb4;
    int mytemperature2;
    //@FXML
    //Button bt5;
    @FXML
    ImageView myimage4;
    @FXML
            private Scene scene;
    @FXML
            private Stage stage;
    @FXML
    private Slider myslider1;
    int blowerSpeed;
    @FXML
    private Label lb5;
    @FXML
    ImageView myimg;
    @FXML
    Button bt6;
    @FXML
    Button bt7;
    @FXML
    ImageView myimage5;
    @FXML
    Button bt9;
    @FXML
    Button bt10;
    @FXML
    Button bt11;


public void ButtonClick(){
    myslide4.setValue(3);
}
public void ButtonClick3(){
myslide4.setValue(8);
}
public void ButtonClick4(){
    myslide4.setValue(1);
}
public void ButtonCLick5(ActionEvent eventt)throws IOException {
        Parent root  =(Parent) FXMLLoader.load(this.getClass().getResource("hello-view.fxml"));
        this.stage =(Stage) ((Node)eventt.getSource()).getScene().getWindow();
        this.scene=new Scene(root);
        this.stage.setScene(this.scene);
    stage.setTitle("THE DEFAULT REMOTE");
        this.stage.show();
    }



public void ButtonClick2(){
    myslide4.setValue(1);
}

public void displayImage2(){
    Image j=new Image(getClass().getResourceAsStream("Capture-removebg-preview.png"));
    myimg.setImage(j);
    System.out.println("swing disabled");
}
    public void displayImage() {

        Image image=new Image(getClass().getResourceAsStream("Capture2-removebg-preview.png"));
        myimg.setImage(image);
System.out.println("Swing enabled");
    }
    public void onSliderChange() {
        int value = (int)myslide4.getValue();
        System.out.println("the value is =" + value);


        int multiplier = 30;
        if (value <=10 ) {
            multiplier*=2;
        }
        int speed = 100+ multiplier*(30-value-20);
        System.out.println(speed);//



        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myimage5);
        rotate.setDuration(Duration.millis(speed));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();


    }

    public void initialize(URL arg0, ResourceBundle args1){
    myslide3.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
            mytemperature2=(int)myslide3.getValue();
            lb4.setText(Integer.toString(mytemperature2) + "°C");


        }
    });
    myslide4.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
        blowerSpeed=(int)myslide4.getValue();
        lb5.setText(Integer.toString(blowerSpeed));

        }
    });
    }
    public void onsliderchange2() {
        int value1 = (int) myslide3.getValue();
        System.out.println("the current temperature is= " +value1 );
        //Color myColor=new Color(0.1906, 0.8696, 0.9895, 1.0);
        //background.setBackground(new Background(new BackgroundFill(myColor,null,null)));
        }
    }



