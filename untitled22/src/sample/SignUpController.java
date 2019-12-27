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
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField city_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField surname_field;

    @FXML
    private Button signUp_field;

    @FXML
    private Button authWindow_field;



    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, Stage primaryStage) {
        primaryStage.setTitle("KOLESA");
        signUp_field.setOnAction(event -> {
            String login = login_field.getText().trim();
            String password = password_field.getText().trim();
            String name = name_field.getText().trim();
            String surname = surname_field.getText().trim();
            String city  = city_field.getText().trim();
            String role = "customer";


            if (login_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели поле логина!");
                alert.show();
            }
            else if (password_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели поле пароля!");
                alert.show();
            }
            else if (name_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели поле имени!");
                alert.show();
            }
            else if (surname_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели поле фамилий!");
                alert.show();
            }
            else if (city_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели значение в поле города!");
                alert.show();
            }
            else {
            try {

                Request req = new Request("REGISTRATION");

                req.setUser(new User(login,password,name,surname,city,"male",role));

                oos.writeObject(req);

                Response res =  (Response)ois.readObject();

                System.out.println(res.getResponse());

                if(res.getResponse().equals("SUCCESSFULLY")){
                    Stage stage = (Stage) authWindow_field.getScene().getWindow();
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
                    Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Authorization was successful!");
                    alert.show();
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            }

        });

        authWindow_field.setOnAction(event -> {
            Stage stage = (Stage) authWindow_field.getScene().getWindow();
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

    }



}

