package com.example.myjavafx;

import com.example.myjavafx.java16.Admin.ShowAdmins;
import com.example.myjavafx.java16.Admin.*;
import com.example.myjavafx.database.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class HelloApplication extends Application implements Initializable {
    private static HelloApplication instance;
    private File file;
    private Image image;
    @FXML
    private ImageView imageView1;
    public Admin admin;
    public Connection databaseLink;
    public TextArea textAreaID;





	@Override
    public void start(Stage Primarystage) throws IOException {
        try {

            instance = this;
//            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("first.fxml"));
//            Parent root = loader.load();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();


            Primarystage.setTitle("Student Information System");
            AnchorPane anchorPane = new AnchorPane();
            InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
            Image image = new Image(stream);
            Primarystage.setResizable(true);
            Primarystage.getIcons().add(image);
            Scene scene = new Scene(root,1131,589);
            Primarystage.setScene(scene);
            Primarystage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException, SQLException {

		DatabaseConnection connection = new DatabaseConnection();
        launch();
    }
    public static HelloApplication getInstance() {
        return instance;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}