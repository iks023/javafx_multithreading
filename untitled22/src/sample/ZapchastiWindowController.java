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
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ZapchastiWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text welcome_text;

    @FXML
    private Button back;

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem profile;

    @FXML
    private MenuItem exit;

    @FXML
    private TextField id_field;

    @FXML
    private Button search_button;

    @FXML
    private TextArea post_text;
    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, User user,Stage primaryStage) {
        primaryStage.setTitle("KOLESA");

        try {
            Request reqallus = new Request("ALL_ZAPCHASTI");
            oos.writeObject(reqallus);

            Response res2 =  (Response)ois.readObject();
            String s ="";
            for (Zapchasti u: res2.getZapchastis()) {
                s = s +"\n"+u.toString();
                s = s + "\n-------------------------------------------------------------------------";
            }
            post_text.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        search_button.setOnAction(event -> {

            if(id_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели запчасть!");
                alert.show();

            }
            else {

                try {
                    Request reqallus = new Request("ALL_ZAPCHASTI");
                    oos.writeObject(reqallus);

                    Response res2 =  (Response)ois.readObject();
                    String s ="";
                    for (Zapchasti u: res2.getZapchastis()) {
                        if (id_field.getText().trim().equalsIgnoreCase(u.getZapchast())){
                        s = s +"\n"+u.toString();
                        s = s + "\n-------------------------------------------------------------------------";
                    }
                    }
                    post_text.setText(s);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }


        });

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
            menu.initialize(oos,ois,user, primaryStage);

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
            profile.initialize(oos,ois,user,primaryStage);

        });

    }
}
