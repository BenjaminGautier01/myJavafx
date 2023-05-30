package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.database.DatabaseConnection;
import com.example.myjavafx.HelloApplication;
import com.example.myjavafx.java16.Admin.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.scene.control.TextArea;

import java.io.OutputStream;

public class DashBoardViewController extends OutputStream implements Initializable {

    @FXML
    public Label WelcomeLabel;
    public Button HomeButton;
    public Button PrintButton;
    public Button ClearButton;
    public ImageView imageviewAdminRegIcon;
    public Button LondonButton;
    public Button HarrowButton;
    public Button KingsburyButton;
    public Button SouthallButton;
    public Button WembleyButton;
    public Label DepartmentsLabel;
    public Label DisplayUserDetailsLabel;
    public ImageView CenterImageview;
    public ImageView imageviewiconsb1;
    public Stage stage;

    @FXML
    private ImageView imageview03, imageviewAdminRegister;
    @FXML
    public Button ShowAdminds;
    public TableView<Admin> Tableview;
    public TableColumn<Admin, Integer> columnID;
    public TableColumn<Admin, String> columnFirstName;
    public TableColumn<Admin, String> columnLastName;
    public TableColumn<Admin, String> columnDateOfBirth;
    public TableColumn<Admin, String> columnGender;
    public TableColumn<Admin, String> columnEmail;
    public TableColumn<Admin, String> columnPassword;

    public DatabaseConnection databaseConnection;
    public Connection databaseLink;
    @FXML
    private Label loginErrorLabel;
    public ImageView imageviewStudent;
    public Button studentPageRegisterButton;
    public Button homeButton;
    public TextArea textAreaID;
    @FXML
    public Button studentPageLoginButton;
    public ImageView studentImageviewhome;
    @FXML

    private Parent root;
    @FXML
    private Button admin;
    @FXML
    private Button student;

    private final TextArea textArea;


    public DashBoardViewController(TextArea textArea) {
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
    public void showImageIcon() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageviewStudent.setImage(image1);

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


    @FXML
    public void showImageNW(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);

        imageviewiconsb1.setImage(image1);

    }

    @FXML
    public void showImageIconLogo() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);

        imageviewiconsb1.setImage(image1);

    }

    @FXML
    public void showImageH1(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\m1.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    @FXML
    public void exitShowImageH1(MouseEvent event) throws FileNotFoundException {
        CenterImageview.setImage(null);
        showImageNow();
    }

    @FXML
    public void showImageL1(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\m2.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    @FXML
    public void exitShowImageL1(MouseEvent event) throws FileNotFoundException {
        CenterImageview.setImage(null);
        showImageNow();
    }

    @FXML
    public void showImageS1(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\m3.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    @FXML
    public void exitShowImageS1(MouseEvent event) throws FileNotFoundException {
        CenterImageview.setImage(null);
        showImageNow();
    }

    @FXML
    public void showImageK1(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\m4.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    @FXML
    public void exitShowImageK1(MouseEvent event) throws FileNotFoundException {
        CenterImageview.setImage(null);
        showImageNow();
    }

    @FXML
    public void showImageW1(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\m5.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    @FXML
    public void exitShowImageW1(MouseEvent event) throws FileNotFoundException {
        CenterImageview.setImage(null);
        showImageNow();
    }

    @FXML
    public void showImage(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\yp-removebg-preview.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    public void showImageNow() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\yp-removebg-preview.png");
        Image image1 = new Image(stream);
        CenterImageview.setImage(image1);

    }

    @FXML
    public void showAdminView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void showDashBoard1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("adminDashBoard-view1.fxml"));
        Parent root = loader.load();
        // Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }


    @FXML
    public void showHello(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
    public void showImageStudentHome(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\pngwing.com.png");
        Image image2 = new Image(stream);
        studentImageviewhome.setImage(image2);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            showImageNow();
            showImageIconLogo();
            textAreaID.setEditable(false);
            textAreaID.setFont(Font.font("Courier New", FontWeight.NORMAL, 12));
            textAreaID.setWrapText(true);
            showImageIcon();
            showImageview1();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
