package com.example.myjavafx.java16.Controllers;


import com.example.myjavafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class hello4Controller {

    @FXML
    private Stage stage;
    private Parent root;
    @FXML
    private Button admin;
    @FXML
    private Button student;

    @FXML
    public void showHello3(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("chatbotLogin-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void showHello5(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello5-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

