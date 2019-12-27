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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class information_page_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text welcome_text;

    @FXML
    private Button back;

    @FXML
    private Text login_text_line;

    @FXML
    private Text password_line;

    @FXML
    private Text name_line;

    @FXML
    private Text surname_line;

    @FXML
    private Text city_line;

    @FXML
    private Text role_line;

    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, Stage primaryStage, User getus) {

        name_line.setText(getus.getName());
        surname_line.setText(getus.getSurname());
        login_text_line.setText(getus.getLogin());
        password_line.setText(getus.getPassword());
        city_line.setText(getus.getCity());
        role_line.setText(getus.getRole());

        back.setOnAction(event -> {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/adminPanel.fxml"));

            try {
                loader.load();
            }catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            AdminPanelController adminPanelController = loader.getController();
            adminPanelController.initialize(oos,ois, primaryStage);
        });


    }
}
