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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javafx.scene.control.TextArea;

public  class Console extends OutputStream implements Initializable {
    public ImageView imageviewStudent;
    public Button studentPageRegisterButton;
    public Button homeButton;
    public TextArea textAreaID;
    @FXML
    public Button studentPageLoginButton;
    public ImageView studentImageviewhome;
    @FXML
    private Stage stage;
    private Parent root;
    @FXML
    private Button admin;
    @FXML
    private Button student;

    private final TextArea textArea;



    public Console(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.appendText(String.valueOf((char) b));
    }

    @Override
    public void write(byte[] b, int off, int len) {
        textArea.appendText(new String(b, off, len));
    }

    @Override
    public void write(byte[] b) {
        write(b, 0, b.length);
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
    public void showStudentRegistrationView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentRegistration-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void showImage(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageviewStudent.setImage(image1);

    }
    @FXML
    public void showImageIcon() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageviewStudent.setImage(image1);

    }
    @FXML
    public void showImageStudentHome(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\pngwing.com.png");
        Image image2 = new Image(stream);
        studentImageviewhome.setImage(image2);

    }
    @FXML
    public void exitShowImageStudentHome(MouseEvent event) throws FileNotFoundException {
        studentImageviewhome.setImage(null);
    }

    @FXML
    public void showImageview1() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\studentPhoto.png");
        Image StudentLogo = new Image(stream);
        studentImageviewhome.setImage(StudentLogo);
    }
    @FXML
    public void showImageview2(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\studentPhoto.png");
        Image StudentLogo = new Image(stream);
        studentImageviewhome.setImage(StudentLogo);
        showImageview1();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{

            textAreaID.setEditable(false);
            textAreaID.setFont(Font.font("Courier New", FontWeight.NORMAL, 12));
            textAreaID.setWrapText(true);
            showImageIcon();
            showImageview1();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void showImageviewLogo(MouseEvent event) {
    }
}
