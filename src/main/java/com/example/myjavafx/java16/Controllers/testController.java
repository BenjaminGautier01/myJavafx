package com.example.myjavafx.java16.Controllers;


import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class testController extends Application implements Initializable {
    @FXML
    public Button testPlayButton;
    @FXML
    public Circle E4;
    public Button connectButton;
    public Label connectLabel;
    public TableColumn<String, String> testCol;
    public TextField TestTextField;
    public Label TestLabel;
    public Button TestButton;
    @FXML
    private  Ellipse E1,E2,E3;
    @FXML
    private ImageView testImageview;
    public Button homeButton;
    public Button ButtonLogin;
    public ImageView imageviewAdminLogin;
    public TextFlow TextFlowLogin;
    public TextArea textAreaAdminLogin;
    public ListView<String> AdminListView;
    @FXML
    private ImageView imageview05;
    @FXML
    private Stage stage;
    public Button ButtonRegister;
    public TextField ConfirmPasswordText;
    public Label ConfirmPasswordLabel;
    public Label PasswordLabel;
    public TextField PasswordText;
    public TextField EmailText;
    public Label EmailLabel;
    public TextField IDText;



    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatBotDashBoardView.fxml"));
        Parent root = loader.load();

        //Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("Test view");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void PlayAnimation(ActionEvent event) throws Exception {
       setRotatations();
    }
    @FXML
    public void setRotatations() throws Exception {

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(E1);
        rotateTransition.setNode(E2);
        rotateTransition.setNode(E3);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(20);
        rotateTransition.play();
    }

    @FXML
    public void showTestImageview() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\adminpic-removebg-preview.png");
        Image logo = new Image(stream);
        testImageview.setImage(logo);

    }
    @FXML
    public void Login(ActionEvent event){

        Map<String,String> credentials = new HashMap<>();
        ObservableMap<String,String> observableMap = FXCollections.observableMap(credentials);// Allows you to be notified when any changes are made to the hashmap.


        String email = TestTextField.getText();
        testCol.setText(email);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            showTestImageview();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }
}
