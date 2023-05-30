package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.database.DatabaseConnection;
import com.example.myjavafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.myjavafx.database.DatabaseConnection.*;

public class StudentLoginViewController implements Initializable {

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
    public Label IDLabel;
    @FXML
    public Label AdminLoginLabel;


    public DatabaseConnection databaseConnection;
    public Connection databaseLink;
    @FXML
    public Label loginErrorLabel;




    @FXML
    public void login(ActionEvent event) {
        StudentLoginViewController d = new StudentLoginViewController();
        String email = EmailText.getText();
        String password = PasswordText.getText();

        if (  password.isEmpty()) {
            loginErrorLabel.setText("Please enter Email and password");
            return;
        }

        try {
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            String query = "SELECT * FROM sis.student WHERE Email = ? AND Password = ?";
            PreparedStatement statement = databaseLink.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Login successful
                //showAdmin();

                d.showDashBoardNoAction();
                loginErrorLabel.setText("login successful");
                System.out.println("login successful");


            } else {
                loginErrorLabel.setText("Invalid email or password");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public  void showDashBoardNoAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentViewOnlyDashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public  void showDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentViewOnlyDashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void showDashBoard(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void clearFields(MouseEvent event) {

        EmailText.setText("");
        PasswordText.setText("");

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
    public void showImage(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageview05.setImage(image1);

    }

    @FXML
    public void showImageview() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\adminIcon-removebg-preview.png");
        Image image2 = new Image(stream);
        imageviewAdminLogin.setImage(image2);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            showImageview();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

