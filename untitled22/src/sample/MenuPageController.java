package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button send_post;


    @FXML
    private Text welcome_text;

    @FXML
    private ImageView cars_click;

    @FXML
    private Button cars_button;

    @FXML
    private ImageView zapchasti_image;

    @FXML
    private Button zapchasti_button;

    @FXML
    private ImageView remont_image;

    @FXML
    private Button remont_button;

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem profile;

    @FXML
    private MenuItem exit;

    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, User user, Stage primaryStage) {
        primaryStage.setTitle("KOLESA");
        welcome_text.setText("Добро Пожаловать," + user.getName());

        send_post.setOnAction(event -> {

            Stage stage = (Stage) send_post.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/sendPostWindow.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            SendPostController send = loader.getController();
            send.initialize(oos,ois,user,primaryStage);

        });


        exit.setOnAction(event -> {
            Stage stage = (Stage) menuButton.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/Login.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            LoginController auth = loader.getController();
            auth.initialize(oos,ois, primaryStage);
        });

        cars_button.setOnAction(event -> {
            Stage stage = (Stage) cars_button.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/car_window.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            CarWindowController cw = loader.getController();
            cw.initialize(oos,ois,user,primaryStage);
        });


        zapchasti_button.setOnAction(event -> {
            Stage stage = (Stage) zapchasti_button.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/zapchasti_window.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ZapchastiWindowController zw = loader.getController();
            zw.initialize(oos,ois,user,primaryStage);

        });

        remont_button.setOnAction(event -> {
            Stage stage = (Stage) remont_button.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/remont_window.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            RemontWindowController rw = loader.getController();
            rw.initialize(oos,ois,user,primaryStage);
        });

        profile.setOnAction(event -> {

            Stage stage = (Stage) menuButton.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/Profile.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ProfileController profile = loader.getController();
            profile.initialize(oos,ois,user, primaryStage);

        });


    }


}