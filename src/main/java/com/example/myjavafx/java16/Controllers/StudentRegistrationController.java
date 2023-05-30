package com.example.myjavafx.java16.Controllers;
import com.example.myjavafx.HelloApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistrationController implements Initializable {
    @FXML
    public Button homeButton;
    @FXML
    private Stage stage;
    @FXML
    private ImageView imageview04;


    @FXML
    public void showStudentRegistrationView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentRegistration-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void showHello(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void showImage(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageview04.setImage(image1);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
