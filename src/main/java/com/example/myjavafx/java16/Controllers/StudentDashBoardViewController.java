package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.HelloApplication;
import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Student.*;
import javafx.fxml.Initializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import static com.example.myjavafx.database.DatabaseConnection.*;

public class StudentDashBoardViewController extends DataBaseConnection implements Initializable {

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
    public Button searchbtnid;
    public Button showButton1;
    public Button StudentButtonID;
    public Button DepartmentButtonID1;
    public Button CourseButtonID11;

    @FXML
    private Stage stage;
    @FXML
    private ImageView imageview03, imageviewAdminRegister;
    @FXML
    public Button ShowStudents;
    public TableView <Student>Tableview;
    public TableColumn <Student, Integer>columnID;
    public TableColumn <Student, String>columnFirstName;
    public TableColumn <Student, String>columnLastName;
    public TableColumn <Student, String>columnDateOfBirth;
    public TableColumn <Student, String>columnGender;
    public TableColumn <Student, String>columnEmail;
    public TableColumn <Student, String>columnPassword;
    @FXML
    private Label loginErrorLabel;



    @FXML
    public  void shStudent(ActionEvent event) {
        try {
            ObservableList<Student> students = getStudents();
            Tableview.setItems(students);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public  void showStudent() {
        try {
            ObservableList<Student> student = getStudents();
            Tableview.setItems(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public ObservableList<Student> getStudents() throws SQLException {
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        databaseLink = getDatabaseConnection();
        String query = "SELECT * FROM sis.student";
        Statement statement;
        ResultSet resultSet;

        try{
            statement = databaseLink.createStatement();
            resultSet = statement.executeQuery(query);
            Student student;
            while(resultSet.next()) {
                Student myStudent = new Student(
                        resultSet.getInt("StudentID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("Confirmpassword"));

                studentList.add(myStudent);

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return studentList;
    }
    @FXML
    public void searchByStudentID(ActionEvent event) throws SQLException {
    try
    {
        // Get the student ID from the input field
        Integer studentID = Integer.valueOf(IDTextField.getText());

        // Make sure that the database connection is established before executing the query
        databaseLink = getDatabaseConnection();

        // Prepare the SQL query
        String sql_query = "SELECT * FROM sis.student WHERE StudentID = ?";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        try {
            // Set the parameter values for the prepared statement
            statement.setInt(1, studentID);

            // Execute the query and retrieve the result set
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and update the table view
            ObservableList<Student> studentList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Student myStudent = new Student(
                        resultSet.getInt("StudentID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Gender"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getString("Confirmpassword"));

                studentList.add(myStudent);

            }Tableview.setItems(studentList);


            // Close the statement and result set
            statement.close();
            resultSet.close();
        }catch(SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    catch (Exception E)
    {

    }

    }


    @FXML
    public void addStudent(ActionEvent event) throws SQLException {
        databaseLink = getDatabaseConnection();
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

        String sql_query = "INSERT INTO sis.student (FirstName, LastName, Gender, DateOfBirth, Email, Password,ConfirmPassword, DateRegistered) VALUES (?, ?, ?, ?, ?, ?, ?,  NOW())";
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
        showStudent();
    }
    @FXML
    public void updateStudent(ActionEvent event) throws SQLException {
        databaseLink = getDatabaseConnection();

        try
        {
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

            //String sql_query = "UPDATE sis.admin SET AdminID=?, FirstName=?, LastName=?, Gender=?, DateOfBirth=?, Email=?, Password=?, ConfirmPassword=?, DateRegistered=NOW() WHERE AdminID=?";
            String student_query ="UPDATE sis.student SET StudentID =?, FirstName=?, LastName=?, Gender=?,DateOfBirth=?, Email=?, Password=?, Confirmpassword=?, DateRegistered=NOW() WHERE StudentID=?";
            PreparedStatement statement = databaseLink.prepareStatement(student_query);

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
        }
        catch (Exception E)
        {

        }

        showStudent();
    }
    //IDTextField.setText(String.valueOf(admin.getId()));

    @FXML
    public void showOnClick(MouseEvent event) {
        Student student = Tableview.getSelectionModel().getSelectedItem();
        if (student != null) { // Make sure an item is selected
            IDTextField.setText(String.valueOf(student.getID()));
            firstNameTextField.setText(student.getFirstName());
            LastNameTextField.setText(student.getLastName());
            EmailText.setText(student.getEmail());
            PasswordText.setText(student.getPassword());
            ConfirmPasswordText.setText(student.getConfirmPassword());

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
    public void deleteStudent(ActionEvent event) throws SQLException {
        databaseLink = getDatabaseConnection();

        try
        {
            System.out.println("databaseLink = " + databaseLink);

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
        showStudent();
    }


    @FXML
    public  void showAllStudent() {
        try {
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("databaseLink = " + databaseLink);
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sis.student");
            while (resultSet.next()) {
                System.out.println("StudentID: " + resultSet.getInt("StudentID") + ", First Name: " + resultSet.getString("FirstName") + "," +
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
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png ");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,1131,589);
        stage.setScene(scene.getRoot().getScene());
        stage.show();
    }
    @FXML
    public void showCourseDashBoardView(ActionEvent event) throws IOException {

//        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("courseDashBoard-view.fxml"));
        Parent root = loader.load();
        //stage = new Stage();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Student Information System");
        AnchorPane anchorPane = new AnchorPane();
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png ");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,1131,589);
        stage.setScene(scene.getRoot().getScene());
        stage.show();
    }
    @FXML
    public void showDepartmentDashBoardViewForStudent(ActionEvent event) throws IOException {

//        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("departmentDashBoard-viewForStudent.fxml"));
        Parent root = loader.load();
        //stage = new Stage();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Student Information System");
        AnchorPane anchorPane = new AnchorPane();
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png ");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,1131,589);
        stage.setScene(scene.getRoot().getScene());
        stage.show();
    }
    @FXML
    public void showCourseDashBoardViewForStudent(ActionEvent event) throws IOException {

//        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("courseDashBoard-viewForStudent.fxml"));
        Parent root = loader.load();
        //stage = new Stage();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Student Information System");
        AnchorPane anchorPane = new AnchorPane();
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png ");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,1131,589);
        stage.setScene(scene.getRoot().getScene());
        stage.show();
    }
    @FXML
    public void showStudentDashView(ActionEvent event) throws IOException {

//        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png ");
//        Image image = new Image(stream);
//
//        stage.setResizable(true);
//        stage.getIcons().add(image);
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("studentDashBoard-view.fxml"));
        Parent root = loader.load();
        stage.setTitle("Student Information System");
        AnchorPane anchorPane = new AnchorPane();
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png ");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,1131,589);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            showImage();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        columnID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("ID"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        columnDateOfBirth.setCellValueFactory(new PropertyValueFactory<Student, String >("dateOfBirth"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<Student, String>("password"));

//
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
