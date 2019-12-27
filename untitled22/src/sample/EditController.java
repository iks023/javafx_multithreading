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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField city_field;

    @FXML
    private Button edit_button;

    @FXML
    private Button back_button;

    @FXML
    private TextField role_field;

    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, Stage primaryStage, User user) {

        System.out.println(user.toString());

        login_field.setText(user.getLogin());
        password_field.setText(user.getPassword());
        name_field.setText(user.getName());
        surname_field.setText(user.getSurname());
        city_field.setText(user.getCity());
        role_field.setText(user.getRole());


        System.out.println(user.getRole());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());

        Long id =  user.getId();

        edit_button.setOnAction(event -> {
            User usernew = new User();
            usernew.setId(id);
            usernew.setLogin(login_field.getText().trim());
            usernew.setPassword(password_field.getText().trim());
            usernew.setName(name_field.getText().trim());
            usernew.setSurname(surname_field.getText().trim());
            usernew.setCity(city_field.getText().trim());
            usernew.setRole(role_field.getText().trim());

            try {
                Request req = new Request("UPDATE_USER");
                req.setUser(usernew);

                oos.writeObject(req);

                Response res =  (Response)ois.readObject();

                System.out.println(res.getResponse());

                if(res.getResponse().equals("SUCCESSFULLY")){
                    Stage stage = (Stage) edit_button.getScene().getWindow();
                    stage.close();
                    Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("ПОЛЬЗОВАТЕЛЬ ИЗМЕНЁН!");
                    alert.show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        back_button.setOnAction(event -> {
            Stage stage = (Stage) edit_button.getScene().getWindow();
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
