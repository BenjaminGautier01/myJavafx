package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.HelloApplication;
import com.example.myjavafx.java16.DataBase.DataBaseConnection;
import com.example.myjavafx.java16.Student.Student;
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

public class CourseDashBoardViewController extends DataBaseConnection implements Initializable {


    //public Student myCourse;
    @FXML
    private Label loginErrorLabel;
    @FXML
    private Stage stage;

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
    public Button ShowCourse;
    public Button ButtonAdd;
    public Label CourseIDlabelID;
    public Label IDid;
    public TextField CourseIDText;
    public Label CourseIDNamelabelID;
    public TextField CourseNameText;
    public javafx.scene.layout.Pane Pane;
    public RadioButton softwareEngineeringRBid;
    public RadioButton computingAndAIRBid;
    public RadioButton businessAndEnterpriseRBid;
    public RadioButton alliedHealthRBid;



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
    public Button searchbtnid;
    public TableView <Student> TableviewID;
    public TableColumn <Student, Integer> columnStudentID;
    public TableColumn <Student, String> columnFirstNameID;
    public TableColumn <Student, String> columnLastNameID;
    public TableColumn <Student, Integer> columnCourseIDID;
    public TableColumn <Student, String> columnCourseNameID;
    public TableColumn <Student, String>columnCourseDurationID;
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
        columnCourseIDID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("CourseID"));
        columnCourseNameID.setCellValueFactory(new PropertyValueFactory<Student, String >("CourseName"));
        columnCourseDurationID.setCellValueFactory(new PropertyValueFactory<Student, String >("CourseDuration"));
        columnEmailID.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
    }

    @FXML
    public  void shCourse(ActionEvent event) {
        try {
            getDatabaseConnection();
            ObservableList<Student> StudentsAndCourse = getStudentAndCourse();
            TableviewID.setItems(StudentsAndCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public ObservableList<Student> getStudentAndCourse() throws SQLException {
        try {
            ObservableList<Student> studentCourseList = FXCollections.observableArrayList();
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            getDatabaseConnection();
            String role ="Default";


            if (alliedHealthRBid.isSelected()) {
                role = "AlliedHealth";
            }
            if (businessAndEnterpriseRBid.isSelected()) {
                role = "BusinessAndEnterprise";
            }
            if (computingAndAIRBid.isSelected()) {
                role = "ComputingAndAI";
            }
            if (softwareEngineeringRBid.isSelected()) {
                role = "SoftwareEngineering";
            }
            if (ShowCourse.isPressed()) {
                role = "Default";
            }

            if (role == null) {
                // Handle no role selected
                return null;
            }

            String sql_query;
            if (role.equals("Default")) {
                sql_query = "SELECT * FROM sis.student";
            }else if (role.equals("SoftwareEngineering")) {
                sql_query = """
                    SELECT s.*, c.CourseName, c.CourseID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CourseID = c.CourseID
                                          WHERE s.CourseID = 2001;
                """;
            } else if (role.equals("ComputingAndAI")) {
                sql_query = """
                    SELECT s.*, c.CourseName, c.CourseID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CourseID = c.CourseID
                                          WHERE s.CourseID = 3001;
                """;
            } else if (role.equals("BusinessAndEnterprise")) {
                sql_query = """
                    SELECT s.*, c.CourseName, c.CourseID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CourseID = c.CourseID
                                          WHERE s.CourseID = 4001;
                """;
            }else if (role.equals("AlliedHealth")) {
                sql_query = """
                    SELECT s.*, c.CourseName, c.CourseID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CourseID = c.CourseID
                                          WHERE s.CourseID = 5001;
                """;
            }
            else {
                // Handle invalid role selection
                System.out.println("Error: Invalid role selection");
                return null;
            }

            //String query = "SELECT * FROM sis.student";
            Statement statement;
            ResultSet resultSet;
            try {
                statement = databaseLink.createStatement();
                resultSet = statement.executeQuery(sql_query);
                Student student;
                while (resultSet.next()) {
                    Student myStudentCourse = new Student(
                            resultSet.getInt("StudentID"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getInt("CourseID"),
                            resultSet.getString("CourseName"),
                            resultSet.getString("CourseDuration"),
                            resultSet.getString("Email"));

                    studentCourseList.add(myStudentCourse);

                }

                TableviewID.setItems(studentCourseList);

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
            return studentCourseList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @FXML
    public  void showCourse() {
        try {
            getDatabaseConnection();
            ObservableList<Student> StudentsAndCourse = getStudentAndCourse();
            TableviewID.setItems(StudentsAndCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addCourse(ActionEvent event) throws SQLException {
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        System.out.println("databaseLink = " + databaseLink);

        String firstName = firstNameTextField.getText();
        String lastName = LastNameTextField.getText();
        int CourseID = Integer.parseInt(CourseIDText.getText());
        String CourseName = CourseNameText.getText();
        String email = EmailText.getText();

        String sql_query = "INSERT INTO sis.student (FirstName, LastName, CourseID, CourseName, Email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setInt(3, CourseID);
        statement.setString(4, CourseName);
        statement.setString(5, email);
        statement.executeUpdate();
        statement.close();
        showCourse();
    }
    @FXML
    public void updateCourse(ActionEvent event) throws SQLException {
        //databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        //System.out.println("databaseLink = " + databaseLink);
        getDatabaseConnection();
        int ID = Integer.parseInt(IDTextField.getText());
        String firstName = firstNameTextField.getText();
        String lastName = LastNameTextField.getText();
        int CourseID = Integer.parseInt(CourseIDText.getText());
        String CourseName = CourseNameText.getText();
        String email = EmailText.getText();

        //String sql_query = "UPDATE sis.admin SET AdminID=?, FirstName=?, LastName=?, Gender=?, DateOfBirth=?, Email=?, Password=?, ConfirmPassword=?, DateRegistered=NOW() WHERE AdminID=?";
        String Course_query = "UPDATE sis.student SET StudentID=?,FirstName=?,LastName=?, CourseID = ? , CourseName = ?,Email=?  WHERE StudentID = ?";

        PreparedStatement statement = databaseLink.prepareStatement(Course_query);

        statement.setInt(   1, ID);
        statement.setString(2, firstName);
        statement.setString(3, lastName);
        statement.setInt(4, CourseID);
        statement.setString(5, CourseName);
        statement.setString(6, email);
        statement.setInt(7, ID);
        statement.executeUpdate();
        statement.close();
        showCourse();
    }
    @FXML

    public void searchByCourseID(ActionEvent event) throws SQLException {

        // Get the Course ID from the input field
        int StudentID = Integer.parseInt(IDTextField.getText());

        // Make sure that the database connection is established before executing the query
        getDatabaseConnection();

        // Prepare the SQL query
        String sql_query = """
                    SELECT s.*, c.CourseName, c.CourseID
                                          FROM sis.student s
                                          JOIN sis.courses c ON s.CourseID = c.CourseID
                                          WHERE s.StudentID = ?;
                """;
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        // Set the parameter values for the prepared statement
        statement.setInt(1, StudentID);

        // Execute the query and retrieve the result set
        ResultSet resultSet = statement.executeQuery();

        // Process the result set and update the table view
        ObservableList<Student> CourseList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            Student Course = new Student(
                    resultSet.getInt("StudentID"),
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("Email"));
            CourseList.add(Course);
        }
        TableviewID.setItems(CourseList);

        // Close the statement and result set
        statement.close();
        resultSet.close();
    }

    //IDTextField.setText(String.valueOf(admin.getId()));

    @FXML
    public void showOnClick(MouseEvent event) {
        try {
            Student studentAndCourse = TableviewID.getSelectionModel().getSelectedItem();
            if (studentAndCourse != null) { // Make sure an item is selected
                IDTextField.setText(String.valueOf(studentAndCourse.getID()));
                firstNameTextField.setText(studentAndCourse.getFirstName());
                LastNameTextField.setText(studentAndCourse.getLastName());
                EmailText.setText(studentAndCourse.getEmail());
                CourseIDText.setText(String.valueOf(studentAndCourse.getCourseID()));
                CourseNameText.setText(studentAndCourse.getCourseName());

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
        CourseIDText.setText("");
        CourseNameText.setText("");

    }
    @FXML
    public void deleteCourse(ActionEvent event) throws SQLException {
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        System.out.println("databaseLink = " + databaseLink);

        int ID = Integer.parseInt(IDTextField.getText());

        String sql_query = "DELETE FROM sis.student WHERE StudentID=?";
        PreparedStatement statement = databaseLink.prepareStatement(sql_query);

        statement.setInt(1, ID);
        statement.executeUpdate();
        statement.close();
        showCourse();
    }

    @FXML
    public  void showAllCourses() {
        try {
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("databaseLink = " + databaseLink);
            Statement statement = databaseLink.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sis.student");
            while (resultSet.next()) {
                System.out.println("StudentID: " + resultSet.getInt("StudentID") + ", First Name: " + resultSet.getString("FirstName") + "," +
                        " Last Name: " + resultSet.getString("LastName") + ", CourseID: " + resultSet.getString("CourseID") + ", CourseName: " + resultSet.getString("CourseName") + ", Email: " + resultSet.getString("Email"));
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
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        imageview03.setImage(image1);

    }
    @FXML
    public void showImage() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png");
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
        InputStream stream = new FileInputStream("C:\\Users\\benja\\source\\my-java-projects\\myJavafx\\src\\photos\\sb1.png ");
        Image image = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image);
        Scene scene = new Scene(root,1131,589);
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
    public void showStudentDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("studentViewOnlyDashboardView.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
