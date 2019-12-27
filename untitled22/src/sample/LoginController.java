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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController{



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginsignupButton;


    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, Stage primaryStage) {
        primaryStage.setTitle("KOLESA");

        authSignInButton.setOnAction(event -> {

            String username = login_field.getText().trim();
            String password= password_field.getText().trim();

            try {
                Request req = new Request("AUTH");
                req.setUser(new User(username, password));

                oos.writeObject(req);

                Response rep = (Response) ois.readObject();
                User user = null;
                if(!rep.getResponse().equals("NOT FOUND")){
                    user = rep.getUser();
                }

                if (user == null) {
                    System.out.println("User has been not found!");

                    Alert alert =  new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("User has been not found!");
                    alert.show();


                }else if (rep.getResponse().equals("ADMIN")){
                    System.out.println("ПРИВЕТ АДМИН");

                    Stage stage = (Stage) authSignInButton.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/FXML/adminPanel.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    AdminPanelController adminpage = loader.getController();
                    adminpage.initialize(oos,ois,primaryStage);


                } else{
                    System.out.println("АВТОРИЗ");

                    Stage stage = (Stage) authSignInButton.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/FXML/Menu.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    MenuPageController menupage = loader.getController();
                    user = rep.getUser();
                    menupage.initialize(oos,ois,user,primaryStage);



                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        loginsignupButton.setOnAction(event -> {
            Stage stage = (Stage) loginsignupButton.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/SignUp.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            SignUpController reg = loader.getController();
            reg.initialize(oos,ois,primaryStage);


        });
    }


}
