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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem profile;

    @FXML
    private MenuItem exit;

    @FXML
    private Text welcome_text;

    @FXML
    private Button back;

    @FXML
    private Button edit_button;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField city_field;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, User user, Stage primaryStage) {
        primaryStage.setTitle("KOLESA");

        login_field.setPromptText(user.getLogin());
        name_field.setPromptText(user.getName());
        password_field.setPromptText(user.getPassword());
        surname_field.setPromptText(user.getSurname());
        city_field.setPromptText(user.getCity());

        back.setOnAction(event -> {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/Menu.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            MenuPageController menu = loader.getController();
            menu.initialize(oos,ois, user, primaryStage);

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
