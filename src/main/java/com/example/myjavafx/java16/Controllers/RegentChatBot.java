package com.example.myjavafx.java16.Controllers;

import com.example.myjavafx.HelloApplication;
import com.example.myjavafx.java16.DataBase.DataBaseConnection;
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
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegentChatBot extends DataBaseConnection implements Initializable {


    public TextArea textAreaID;
    public ImageView imageviewStudent, imageview, imageview03;
    public Button homeButton;
    public Button handleInputID;
    @FXML
    private TextArea chatBox;
    @FXML
    private Stage stage;
    @FXML
    private TextField inputBox;
    Map<String, String> responses = new HashMap<>();
    @SuppressWarnings("resource")
	@FXML
    public void handleInput(@SuppressWarnings("exports") ActionEvent event){
        //final Map<String, String> responses = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = inputBox.getText().toLowerCase();
            inputBox.clear();

            if (input.equals("exit")) {
            chatBox.appendText("Goodbye!\n");
            return;
        }
            if (responses.containsKey(input)) {
            chatBox.appendText(responses.get(input) + "\n");
        } else {
            chatBox.appendText("I'm sorry, I didn't understand your question. Please try again.\n");
        }

        scanner.close();
    }



    @FXML
    public void showHello(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);
        stage.setResizable(true);
        stage.getIcons().add(image1);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showImageIcon();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        responses.put("hello", "Hello! How can I help you today?");
        responses.put("what information does the system store?", "The system stores information about courses, students, and campuses.\n" +
                                                                 " Student records can be viewed, inserted, deleted, and searched by staff members.");
        responses.put("how are you", "I'm doing well, thank you! How about you?");
        responses.put("what actions can staff members perform?", "Staff members can view, insert, delete, and search student records.");
        responses.put("what courses are available?", "The system offers courses for undergraduates and postgraduates.\n " +
                                                     "Courses offered by each department and available on each campus");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("what is your name", "My name is Chatbot, nice to meet you!");
        responses.put("what can you do", "I can answer your questions about a variety of topics.\n" +
                                         " Try asking me about something that interests you!\n");
        responses.put("how old are you", "I was just created, so I'm brand new!");
        responses.put("what is the meaning of life", "That's a tough question. Different people have different answers.\n ");
        responses.put("tell me a joke", "Why did the tomato turn red? Because it saw the salad dressing!");

        responses.put("what is your favorite color", "I don't have a favorite color, as I am just a chatbot.");
        responses.put("what is the weather like", "I'm sorry, I don't have access to real-time weather data.\n " +
                                                  "You can check your local weather forecast online.");
        responses.put("what is the capital of France", "The capital of France is Paris.");
        responses.put("how do i cook pasta", "To cook pasta, boil a large pot of salted water and add the pasta. \n" +
                                             "Cook the pasta for the amount of time specified on the package,\n" +
                                             " then drain the water and add your desired sauce.");
        responses.put("what is the largest animal in the world", "The largest animal in the world is the blue whale.");
        responses.put("what is the square root of 64", "The square root of 64 is 8.");
        responses.put("how do i change a flat tire", "To change a flat tire, first make sure you are in a safe location and have the necessary tools.\n " +
                                                     "Then, loosen the lug nuts, jack up the car, \n" +
                                                     "remove the lug nuts and old tire, put on the spare tire, \n" +
                                                     "tighten the lug nuts, and lower the car.");
        responses.put("what is the population of New York City", "The population of New York City is approximately 8.3 million people.");
        responses.put("how do i make a grilled cheese sandwich", "To make a grilled cheese sandwich, butter one side of two slices of bread and place a slice of cheese between them.\n" +
                                                                 " Cook the sandwich in a pan over medium heat until the bread is golden brown and the cheese is melted.");
        responses.put("what is the largest country in the world", "The largest country in the world is Russia.");
        responses.put("how do i tie a tie", "To tie a tie, start with the wide end of the tie on your right side and the narrow end on your left. \n" +
                                            "Cross the wide end over the narrow end, then bring it up and over the loop around your neck. \n" +
                                            "Bring the wide end down, behind the knot, and to the left. \n" +
                                            "Cross the wide end over the narrow end again, \n" +
                                            "bring it up and over the loop, \n" +
                                            "then tuck it down through the loop and tighten the knot.");
        responses.put("what is the capital of Canada", "The capital of Canada is Ottawa.");
    }
}
