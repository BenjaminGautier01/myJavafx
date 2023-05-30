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
import javafx.scene.control.TextArea;
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

public class studentController implements Initializable {

    @FXML
    public Button studentPageLoginButton;
    public Button homeButton;
    public ImageView studentImageviewhome;

    @FXML
    private Stage stage;
    private Parent root;
    @FXML
    private Button admin;
    @FXML
    private Button studentPageRegisterButton;
    @FXML
    private Button student;
    @FXML
    private ImageView imageviewStudent;



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
    public void showStudentRegistrationView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentRegistration-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void showStudentLoginView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentLogin-view.fxml"));
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
        imageviewStudent.setImage(image1);

    }
    @FXML
    public void showImageIcon() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageviewStudent.setImage(image1);

    }
    @FXML
    public void showImageStudentHome(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\pngwing.com.png");
        Image image2 = new Image(stream);
        studentImageviewhome.setImage(image2);

    }
    @FXML
    public void exitShowImageStudentHome(MouseEvent event) throws FileNotFoundException {
        studentImageviewhome.setImage(null);
    }



    @FXML
    public void showImageStudentLogin(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\studentLogin-removebg-preview.png");
        Image image2 = new Image(stream);
        studentImageviewhome.setImage(image2);

    }
    @FXML
    public void exitShowImageStudentLogin(MouseEvent event) throws FileNotFoundException {
        studentImageviewhome.setImage(null);
    }
    @FXML
    public void showImageview1() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\studentPhoto.png");
        Image StudentLogo = new Image(stream);
        studentImageviewhome.setImage(StudentLogo);
    }
    @FXML
    public void showImageview2(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\studentPhoto.png");
        Image StudentLogo = new Image(stream);
        studentImageviewhome.setImage(StudentLogo);
        showImageview1();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            showImageIcon();
            showImageview1();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}