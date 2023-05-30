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

public class adminController implements Initializable {
    @FXML
    public Button registerButton;
    public Button adminLoginButton;
    public Button homeButton;
    @FXML
    private Stage stage;
    private Parent root;
    @FXML
    private Button admin;
    @FXML
    private Button student;
    @FXML
    private Image image;
    @FXML
    private ImageView imageview02;
    @FXML
    private  ImageView adminImageView;

    @FXML
    public void showDashBoard() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dashBoard-view.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void showDashBoard1(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dashBoard-view.fxml"));
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
    public void showAdminRegistrationView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("adminRegistration-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void showAdminLoginView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("adminLogin-view.fxml"));
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
        imageview02.setImage(image1);

    }
    @FXML
    public void showImage1() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageview02.setImage(image1);

    }
    @FXML
    public void showImageview1() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\adminRegisterImage.png");
        Image logo = new Image(stream);
        adminImageView.setImage(logo);
    }
    @FXML
    public void showImageview2(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\adminRegisterImage.png");
        Image logo = new Image(stream);
        adminImageView.setImage(logo);
    }
    @FXML
    public void showImageAdminHome(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\pngwing.com.png");
        Image image2 = new Image(stream);
        adminImageView.setImage(image2);

    }
    @FXML
    public void exitShowImageAdminHome(MouseEvent event) throws FileNotFoundException {
        adminImageView.setImage(null);
        showImageview1();
    }

    @FXML
    public void showImageAdminLoginButton(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\adminIcon.png");
        Image image3 = new Image(stream);
        adminImageView.setImage(image3);

    }
    @FXML
    public void exitShowImageAdminLoginButton(MouseEvent event) throws FileNotFoundException {
        adminImageView.setImage(null);

    }
    @FXML
    public void showImageAdminRegisterButton(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\ad-regis-image.png");
        Image image3 = new Image(stream);
        adminImageView.setImage(image3);
    }
    @FXML
    public void exitShowImageAdminRegisterButton(MouseEvent event) throws FileNotFoundException {
        adminImageView.setImage(null);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            showImage1();
            showImageview1();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
