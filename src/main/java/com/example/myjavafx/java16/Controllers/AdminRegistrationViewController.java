package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.database.DatabaseConnection;
import com.example.myjavafx.HelloApplication;
import com.example.myjavafx.java16.Admin.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.example.myjavafx.database.DatabaseConnection.*;

public class AdminRegistrationViewController implements Initializable {
    @FXML
    public TextField ConfirmPasswordText;
    public Label ConfirmPasswordLabel;
    public Label PasswordLabel;
    public TextField PasswordText;
    public TextField EmailText;
    public Label EmailLabel;
    public TextField IDTextField;
    public TextField firstNameTextField;
    public TextField LastNameTextField;
    public RadioButton maleRadioButton;
    public RadioButton femaleRadioButton;
    public javafx.scene.control.DatePicker DatePicker;
    public Label LabelShowinfo;
    public Label labelFirstName;
    public Label labelGender;
    public Label labelDOB;
    public Label labelLastName;
    @FXML
    public Button UpdateButton;
    public Button deleteButton;
    public Button homeButton;
    public Button ButtonRegister;
    public Button clearButton;

    @FXML
    private Stage stage;
    @FXML
    private ImageView imageview03, imageviewAdminRegister;
    @FXML
    public Button ShowAdminds;
    public TableView <Admin>Tableview;
    public TableColumn <Admin, Integer>columnID;
    public TableColumn <Admin, String>columnFirstName;
    public TableColumn <Admin, String>columnLastName;
    public TableColumn <Admin, String>columnDateOfBirth;
    public TableColumn <Admin, String>columnGender;
    public TableColumn <Admin, String>columnEmail;
    public TableColumn <Admin, String>columnPassword;

    public DatabaseConnection databaseConnection;
    public Connection databaseLink;
    @FXML
    private Label loginErrorLabel;


    @FXML
    public  void shAdmin(ActionEvent event) {
        try {
            ObservableList<Admin> admins = getAdministrators();
            Tableview.setItems(admins);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public  void showAdmin() {
        try {
            ObservableList<Admin> admins = getAdministrators();
            Tableview.setItems(admins);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public ObservableList<Admin> getAdministrators() throws SQLException {
        ObservableList<Admin> adminList = FXCollections.observableArrayList();
        databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        String query = "SELECT * FROM sis.admin";
        Statement statement;
        ResultSet resultSet;

        try{
            statement = databaseLink.createStatement();
            resultSet = statement.executeQuery(query);
            Admin admin;
            while(resultSet.next()) {
                Admin myAdmin = new Admin(
                        resultSet.getInt("AdminID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("ConfirmPassword"));

                adminList.add(myAdmin);

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return adminList;
    }

    @FXML
    public void addAdmin(ActionEvent event) throws SQLException {
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        System.out.println("databaseLink = " + databaseLink);

        String firstName = firstNameTextField.getText();
        String lastName = LastNameTextField.getText();
        String email = EmailText.getText();
        String password = PasswordText.getText();
        String ConfirmPassword = ConfirmPasswordText.getText();
        String dateOfBirth = String.valueOf(DatePicker.getValue());
        String gender = null;

        if (maleRadioButton.isSelected()) {
            gender = maleRadioButton.getText();
        }
        if (femaleRadioButton.isSelected()) {
            gender = femaleRadioButton.getText();
        }

        String sql_query = "INSERT INTO sis.admin (FirstName, LastName, Gender, DateOfBirth, Email, Password,ConfirmPassword, DateRegistered) VALUES (?, ?, ?, ?, ?, ?, ?,  NOW())";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, gender);
        statement.setString(4, dateOfBirth);
        statement.setString(5, email);
        statement.setString(6, password);
        statement.setString(7, ConfirmPassword );
        statement.executeUpdate();
        statement.close();
        showAdmin();
    }
    @FXML
    public void updateAdmin(ActionEvent event) throws SQLException {
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        System.out.println("databaseLink = " + databaseLink);

        Integer ID = Integer.valueOf(IDTextField.getText());
        String firstName = firstNameTextField.getText();
        String lastName = LastNameTextField.getText();
        String email = EmailText.getText();
        String password = PasswordText.getText();
        String ConfirmPassword = ConfirmPasswordText.getText();
        String dateOfBirth = String.valueOf(DatePicker.getValue());
        String gender = null;

        if (maleRadioButton.isSelected()) {
            gender = maleRadioButton.getText();
        }
        if (femaleRadioButton.isSelected()) {
            gender = femaleRadioButton.getText();
        }

        String sql_query = "UPDATE sis.admin SET AdminID=?, FirstName=?, LastName=?, Gender=?, DateOfBirth=?, Email=?, Password=?, ConfirmPassword=?, DateRegistered=NOW() WHERE AdminID=?";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setInt(   1, ID);
        statement.setString(2, firstName);
        statement.setString(3, lastName);
        statement.setString(4, gender);
        statement.setString(5, dateOfBirth);
        statement.setString(6, email);
        statement.setString(7, password);
        statement.setString(8, ConfirmPassword );
        statement.setInt(   9, ID);
        statement.executeUpdate();
        statement.close();
        showAdmin();
    }
    //IDTextField.setText(String.valueOf(admin.getId()));

    @FXML
    public void showOnClick(MouseEvent event) {
        Admin admin = Tableview.getSelectionModel().getSelectedItem();
        if (admin != null) { // Make sure an item is selected
            IDTextField.setText(String.valueOf(admin.getID()));
            firstNameTextField.setText(admin.getFirstName());
            LastNameTextField.setText(admin.getLastName());
            EmailText.setText(admin.getEmail());
            PasswordText.setText(admin.getPassword());
            ConfirmPasswordText.setText(admin.getConfirmPassword());

        }
    }
    @FXML
    public void clearFields(ActionEvent event) {
        IDTextField.setText("");
        firstNameTextField.setText("");
        LastNameTextField.setText("");
        EmailText.setText("");
        PasswordText.setText("");
        ConfirmPasswordText.setText("");
        DatePicker.setValue(null);
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
    }
    @FXML
    public void deleteAdmin(ActionEvent event) throws SQLException {
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        System.out.println("databaseLink = " + databaseLink);

        Integer ID = Integer.valueOf(IDTextField.getText());

        String sql_query = "DELETE FROM sis.admin WHERE AdminID=?";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setInt(1, ID);
        statement.executeUpdate();
        statement.close();
        showAdmin();
    }










    @FXML
    public  void showAllAdmin() {
        try {
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("databaseLink = " + databaseLink);
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sis.admin");
            while (resultSet.next()) {
                System.out.println("AdminID: " + resultSet.getInt("AdminID") + ", First Name: " + resultSet.getString("FirstName") + "," +
                        " Last Name: " + resultSet.getString("LastName") + ", Gender: " + resultSet.getString("Gender") + ", DateOfBirth: " + resultSet.getString("DateOfBirth") + ", Email: " + resultSet.getString("Email") +", Password: " + resultSet.getString("Password"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageview03.setImage(image1);

    }
    @FXML
    public void showImageview() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\adminRegIcon-removebg-preview.png");
        Image image2 = new Image(stream);
        imageviewAdminRegister.setImage(image2);

    }
    @FXML
    public void showDashviewView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dashBoard-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnID.setCellValueFactory(new PropertyValueFactory<Admin,Integer>("id"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<Admin, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Admin, String>("lastName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<Admin, String>("gender"));
        columnDateOfBirth.setCellValueFactory(new PropertyValueFactory<Admin, String >("dateOfBirth"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Admin, String>("email"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<Admin, String>("password"));

        try {
            showImageview();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
