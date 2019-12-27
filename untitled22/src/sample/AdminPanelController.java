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

public class AdminPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text welcome_text;

    @FXML
    private Button exit;

    @FXML
    private Button remove_button;

    @FXML
    private TextField id_field;

    @FXML
    private Button update_button;

    @FXML
    private Button search_button;

    @FXML
    private Button add_admin;

    @FXML
    private TextArea all_users;

    @FXML
    private TextArea car_text;

    @FXML
    private TextField id_car;

    @FXML
    private Button delete_car;

    @FXML
    private TextArea zapchasti_text;

    @FXML
    private Button zapchasti_delete;

    @FXML
    private TextField delete_post_zapchasti;

    @FXML
    private TextArea remont_text;

    @FXML
    private Button delete_remont;

    @FXML
    private TextField id_remont;

    @FXML
    private TextField login_admin;

    @FXML
    private TextField password_admin;

    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, Stage primaryStage) {
        primaryStage.setTitle("KOLESA");

        add_admin.setOnAction(event -> {

            if(login_admin.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели логин!");
                alert.show();
            }
            else if(password_admin.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели пароль!");
                alert.show();
            }
            else {
                try {
                    Request req = new Request("ADD_ADMIN");
                    User u = new User(login_admin.getText().trim(),password_admin.getText().trim(),"admin","admin","admin","admin","admin");
                    req.setUser(u);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Админ добавлен!");
                        alert.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }


        });

        try {
            Request reqallus = new Request("ALL_USER");
            oos.writeObject(reqallus);

            Response res2 =  (Response)ois.readObject();

            String s ="";
            for (User u: res2.getAllusers()) {
                s = s +"\n"+u.toString();
                s = s + "\n---------------------------------";
            }
            all_users.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Request reqallus = new Request("ALL_CAR");
            oos.writeObject(reqallus);

            Response res2 =  (Response)ois.readObject();
            String s ="";
            for (Car u: res2.getCars()) {
                s = s +"\n"+u.toString();
                s = s + "\n---------------------------------";
            }
            car_text.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Request reqallus = new Request("ALL_ZAPCHASTI");
            oos.writeObject(reqallus);

            Response res2 =  (Response)ois.readObject();
            String s ="";
            for (Zapchasti u: res2.getZapchastis()) {
                s = s +"\n"+u.toString();
                s = s + "\n---------------------------------";
            }
            zapchasti_text.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Request reqallus = new Request("ALL_REMONT");
            oos.writeObject(reqallus);

            Response res2 =  (Response)ois.readObject();
            String s ="";
            for (Remont u: res2.getRemonts()) {
                s = s +"\n"+u.toString();
                s = s + "\n---------------------------------";
            }
            remont_text.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        delete_remont.setOnAction(event -> {

            if(id_remont.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели id!");
                alert.show();
            }
            else {
                try {
                    Request req = new Request("REMOVE_REM");
                    Long id = Long.parseLong(id_remont.getText().trim());
                    Remont rem = new Remont();
                    rem.setId(id);
                    System.out.println(id);
                    req.setRem(rem);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Пост был удален!");
                        alert.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        zapchasti_delete.setOnAction(event -> {

            if(delete_post_zapchasti.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели id!");
                alert.show();
            }
            else {
                try {
                    Request req = new Request("REMOVE_ZAP");
                    Long id = Long.parseLong(delete_post_zapchasti.getText().trim());
                    Zapchasti zap = new Zapchasti();
                    zap.setId(id);
                    System.out.println(id);
                    req.setZap(zap);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Пост был удален!");
                        alert.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });




        delete_car.setOnAction(event -> {

            if(id_car.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели id!");
                alert.show();
            }
            else {
                try {
                    Request req = new Request("REMOVE_CAR");
                    Long id = Long.parseLong(id_car.getText().trim());
                    Car car = new Car();
                    car.setId(id);
                    System.out.println(id);
                    req.setCar(car);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Пост был удален!");
                        alert.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });





        search_button.setOnAction(event -> {

            if(id_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели id!");
                alert.show();
            }
            else {

                try {
                    Request req = new Request("GET_USER");
                    Long id = Long.parseLong(id_field.getText().trim());
                    User user = new User();
                    user.setId(id);
                    req.setUser(user);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    if(res.getResponse().equals("SUCCESSFULLY")){

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/FXML/information_user.fxml"));

                        try {
                            loader.load();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                        information_page_Controller info = loader.getController();
                        User getus = res.getUser();
                        info.initialize(oos,ois, primaryStage,getus);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }

            });

        update_button.setOnAction(event -> {

            if(id_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели id!");
                alert.show();
            }
            else {
                try {
                    Request req = new Request("GET_USER");
                    Long id = Long.parseLong(id_field.getText().trim());
                    User user = new User();
                    user.setId(id);
                    req.setUser(user);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();
                    System.out.println(res.getResponse());
                    System.out.println(res.getUser());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/FXML/update_user.fxml"));

                        try {
                            loader.load();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                        EditController edit = loader.getController();
                        User getus = res.getUser();
                        edit.initialize(oos,ois, primaryStage,getus);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        remove_button.setOnAction(event -> {

            if(id_field.getLength()<1){
                Alert alert =  new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Вы не ввели id!");
                alert.show();
            }
            else {
                try {
                    Request req = new Request("REMOVE_USER");
                    Long id = Long.parseLong(id_field.getText().trim());
                    User user = new User();
                    user.setId(id);
                    req.setUser(user);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Аккаунт успешно удален");
                        alert.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        exit.setOnAction(event -> {
            Stage stage = (Stage) exit.getScene().getWindow();
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
