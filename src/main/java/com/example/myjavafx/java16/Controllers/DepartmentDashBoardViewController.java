package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.HelloApplication;

import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Department.Department;
import com.example.myjavafx.java16.Student.Student;
//import com.example.myjavafx.database.DatabaseConnection;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DepartmentDashBoardViewController extends DataBaseConnection implements Initializable {

    //public Student myStudent;

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
    public Button ShowDepartment;
    public Button ButtonAdd;
    public Label DepartmentIDlabelID;
    public Label IDid;
    public TextField DepartmentIDText;
    public Label DepartmentIDNamelabelID;
    public TextField DepartmentNameText;
    public javafx.scene.layout.Pane Pane;
    public RadioButton kingsburyRBid;
    public RadioButton southburyRBid;
    public RadioButton wembleyRBid;
    public RadioButton harrowRBid;
    public RadioButton londonRBid;

    @FXML
    private Label loginErrorLabel;
    @FXML
    private Stage stage;
    @FXML
    private ImageView imageview03, imageviewAdminRegister;
    //public DataBaseConnection dataBaseConnection;
    //public Connection databaseLink;
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
    public Button DashboardButton;
    public Button homeButton1;
    public Button ShowAdminds;
    public Button searchbtnid;
    public TableView <Student> TableviewID;
    public TableColumn <Student, Integer> columnStudentID;
    public TableColumn <Student, String> columnFirstNameID;
    public TableColumn <Student, String> columnLastNameID;
    public TableColumn <Student, Integer> columnDepartmentIDID;
    public TableColumn <Student, String> columnDepartmentNameID;
    public TableColumn <Student, String> columnEmailID;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getDatabaseConnection();
            showImage();
        } catch (FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);}

        columnStudentID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("ID"));
        columnFirstNameID.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        columnLastNameID.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        columnDepartmentIDID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("DepartmentID"));
        columnDepartmentNameID.setCellValueFactory(new PropertyValueFactory<Student, String >("DepartmentName"));
        columnEmailID.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
    }

    @FXML
    public  void shDepartment(ActionEvent event) {
        try {
            getDatabaseConnection();
            ObservableList<Student> StudentsAndStudent = getStudentsAndDepartment();
            TableviewID.setItems(StudentsAndStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public ObservableList<Student> getStudentsAndDepartment() throws SQLException {
        try {
            ObservableList<Student> studentDepartmentList = FXCollections.observableArrayList();
            databaseLink = getDatabaseConnection();
            getDatabaseConnection();
            String role ="Default";

            if (londonRBid.isSelected()) {
                role = "LondonStudent";
            }
            if (harrowRBid.isSelected()) {
                role = "HarrowStudent";
            }
            if (wembleyRBid.isSelected()) {
                role = "WembleyStudent";
            }
            if (southburyRBid.isSelected()) {
                role = "SouthburyStudent";
            }
            if (kingsburyRBid.isSelected()) {
                role = "KingsburyStudent";
            }
            if (ShowDepartment.isPressed()) {
                role = "Default";
            }

            if (role == null) {
                // Handle no role selected
                return null;
            }

            String sql_query;
            if (role.equals("Default")) {
                sql_query = "SELECT * FROM sis.student";
            }else if (role.equals("LondonStudent")) {
                sql_query = "SELECT StudentID, FirstName, LastName, DepartmentID, DepartmentName, Email FROM sis.student " + "WHERE DepartmentID = 1";
            } else if (role.equals("HarrowStudent")) {
                sql_query = "SELECT StudentID,FirstName, LastName, DepartmentID, DepartmentName, Email FROM sis.student " + "WHERE DepartmentID = 2";
            } else if (role.equals("WembleyStudent")) {
                sql_query = "SELECT StudentID,FirstName, LastName, DepartmentID, DepartmentName, Email FROM sis.student " + "WHERE DepartmentID = 3";
            } else if (role.equals("SouthburyStudent")) {
                sql_query = "SELECT StudentID,FirstName, LastName, DepartmentID, DepartmentName, Email FROM sis.student " + "WHERE DepartmentID = 4";
            } else if (role.equals("KingsburyStudent")) {
                sql_query = "SELECT StudentID,FirstName, LastName, DepartmentID, DepartmentName, Email FROM sis.student  " + "WHERE DepartmentID = 5";
            } else {
                // Handle invalid role selection
                System.out.println("Error: Invalid role selection");
                return null;
            }

            //String query = "SELECT * FROM sis.student";
            Statement statement;
            ResultSet resultSet;

            //        String query = "SELECT * FROM sis.student";
            //        Statement statement;
            //        ResultSet resultSet;


            try {
                statement = databaseLink.createStatement();
                resultSet = statement.executeQuery(sql_query);
                Student student;
                while (resultSet.next()) {
                    Student myStudentDepartment = new Student(
                            resultSet.getInt("StudentID"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getInt("DepartmentID"),
                            resultSet.getString("DepartmentName"),
                            resultSet.getString("Email"));

                    studentDepartmentList.add(myStudentDepartment);

                }

                TableviewID.setItems(studentDepartmentList);

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
            return studentDepartmentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @FXML
    public  void showDepartment() {
        try {
            getDatabaseConnection();
            ObservableList<Student> StudentsAndDepartment = getStudentsAndDepartment();
            TableviewID.setItems(StudentsAndDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addDepartment(ActionEvent event) throws SQLException {
        databaseLink = getDatabaseConnection();
        try
        {
            getStudentsAndDepartment();
            System.out.println("databaseLink = " + databaseLink);

            String firstName = firstNameTextField.getText();
            String lastName = LastNameTextField.getText();
            Integer DepartmentID = Integer.parseInt(DepartmentIDText.getText());
            String DepartmentName = DepartmentNameText.getText();
            String email = EmailText.getText();

            String sql_query = "INSERT INTO sis.student (FirstName, LastName, DepartmentID, DepartmentName, Email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, DepartmentID);
            statement.setString(4, DepartmentName);
            statement.setString(5, email);
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception E)
        {

        }
        showDepartment();
    }
    @FXML
    public void updateDepartment(ActionEvent event) throws SQLException {
        //databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        //System.out.println("databaseLink = " + databaseLink);
        databaseLink = getDatabaseConnection();

        try
        {
            Integer ID = Integer.valueOf(IDTextField.getText());
            String firstName = firstNameTextField.getText();
            String lastName = LastNameTextField.getText();
            Integer DepartmentID = Integer.parseInt(DepartmentIDText.getText());
            String DepartmentName = DepartmentNameText.getText();
            String email = EmailText.getText();

            //String sql_query = "UPDATE sis.admin SET AdminID=?, FirstName=?, LastName=?, Gender=?, DateOfBirth=?, Email=?, Password=?, ConfirmPassword=?, DateRegistered=NOW() WHERE AdminID=?";
            String student_query ="UPDATE sis.student SET StudentID =?, FirstName=?, LastName=?,DepartmentID=?, DepartmentName=?, Email=? WHERE StudentID=?";
            PreparedStatement statement = databaseLink.prepareStatement(student_query);

            statement.setInt(   1, ID);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setInt(4, DepartmentID);
            statement.setString(5, DepartmentName);
            statement.setString(6, email);
            statement.setInt(7, ID);
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception E)
        {

        }
        showDepartment();
    }
    @FXML
    public void searchByStudentID(ActionEvent event) throws SQLException {


        databaseLink = getDatabaseConnection();

        try{
            // Get the student ID from the input field
            Integer studentID = Integer.valueOf(IDTextField.getText());

            // Make sure that the database connection is established before executing the query
            getDatabaseConnection();

            // Prepare the SQL query
            String sql_query = "SELECT * FROM sis.student WHERE StudentID = ?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            // Set the parameter values for the prepared statement
            statement.setInt(1, studentID);

            // Execute the query and retrieve the result set
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and update the table view
            ObservableList<Student> DepartmentList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("StudentID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getInt("DepartmentID"),
                        resultSet.getString("DepartmentName"),
                        resultSet.getString("Email"));
                DepartmentList.add(student);
            }
            TableviewID.setItems(DepartmentList);

            // Close the statement and result set
            statement.close();
            resultSet.close();
        }
        catch (Exception E)
        {

        }
    }

    //IDTextField.setText(String.valueOf(admin.getId()));

    @FXML
    public void showOnClick(MouseEvent event) {
        try {
            Student studentAndStudent = TableviewID.getSelectionModel().getSelectedItem();
            if (studentAndStudent != null) { // Make sure an item is selected
                IDTextField.setText(String.valueOf(studentAndStudent.getID()));
                firstNameTextField.setText(studentAndStudent.getFirstName());
                LastNameTextField.setText(studentAndStudent.getLastName());
                EmailText.setText(studentAndStudent.getEmail());
                DepartmentIDText.setText(String.valueOf(studentAndStudent.getDepartmentID()));
                DepartmentNameText.setText(studentAndStudent.getDepartmentName());

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void clearFields(ActionEvent event) {
        IDTextField.setText("");
        firstNameTextField.setText("");
        LastNameTextField.setText("");
        EmailText.setText("");
        DepartmentIDText.setText("");
        DepartmentNameText.setText("");

    }
    @FXML
    public void deleteDepartment(ActionEvent event) throws SQLException {
        databaseLink = getDatabaseConnection();
        try
        {
            Integer ID = Integer.valueOf(IDTextField.getText());

            String sql_query = "DELETE FROM sis.student WHERE StudentID=?";
            PreparedStatement statement = databaseLink.prepareStatement(sql_query);

            statement.setInt(1, ID);
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception E)
        {

        }
        showDepartment();
    }

    @FXML
    public  void showAllDepartment() {
        try {
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("databaseLink = " + databaseLink);
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sis.student");
            while (resultSet.next()) {
                System.out.println("StudentID: " + resultSet.getInt("StudentID") + ", First Name: " + resultSet.getString("FirstName") + "," +
                        " Last Name: " + resultSet.getString("LastName") + ", DepartmentID: " + resultSet.getString("DepartmentID") + ", DepartmentName: " + resultSet.getString("DepartmentName") + ", Email: " + resultSet.getString("Email"));
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
    public void showImage() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageview03.setImage(image1);

    }
    @FXML
    public void showAdminDashBoardView1(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("adminDashBoard-view1.fxml"));
        Parent root = loader.load();
        //stage = new Stage();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Student Information System");
        AnchorPane anchorPane = new AnchorPane();
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,900,600);
        stage.setScene(scene.getRoot().getScene());
        stage.show();
    }

    @FXML
    public void showDashView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void showDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentViewOnlyDashboardView.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
