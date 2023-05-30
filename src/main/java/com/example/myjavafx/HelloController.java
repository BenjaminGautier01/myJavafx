package com.example.myjavafx;
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

@SuppressWarnings("unused")
public class HelloController implements Initializable {
    @FXML
    public ImageView imageview;
    public Button studentbtn;
    public Button adminbtn;
    public Button chatbotbtn;
    @FXML
    private Stage stage;
    private Parent root;
    private Image image1,image2,image3;
    @FXML
    private ImageView imageview01;

    @FXML
    public void adminView(@SuppressWarnings("exports") ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Image image = new Image(System.getProperty("user.dir") + "\\src\\sb.jpg");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void studentView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("student-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void showHello3(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("chatbotLogin-view.fxml"));
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

        imageview01.setImage(image1);

    }
    @FXML
    public void showImageIconLogo() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\sb1.png");
        Image image1 = new Image(stream);

        imageview01.setImage(image1);

    }

    @FXML
    public void showImage1(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\admin.png");
        Image image1 = new Image(stream);
        imageview.setImage(image1);

    }

    @FXML
    public void exitImage1(MouseEvent event) throws FileNotFoundException {
        imageview.setImage(null);
    }
    @FXML
    public void showImage2(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\student.png");
        Image image2 = new Image(stream);
        imageview.setImage(image2);
    }
    @FXML
    public void exitImage2(MouseEvent event) throws FileNotFoundException {
        imageview.setImage(null);
    }
    @FXML
    public void showImage3(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\chatbot.png");
        Image image3 = new Image(stream);
        imageview.setImage(image3);
    }
    @FXML
    public void exitImage3(MouseEvent event) throws FileNotFoundException {
        imageview.setImage(null);
    }
    @FXML
    public void showImageviewLogo(MouseEvent event) throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\pngwing.com.png");
        Image logo = new Image(stream);
        imageview.setImage(logo);

    }
    @FXML
    public void showImageview() throws FileNotFoundException {
        InputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\photos\\pngwing.com.png");
        Image logo = new Image(stream);
        imageview.setImage(logo);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            showImageview();
            showImageIconLogo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}