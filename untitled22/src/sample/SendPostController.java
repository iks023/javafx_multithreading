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

public class SendPostController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button zapchasti_button;

    @FXML
    private Text welcome_text;


    @FXML
    private Button back;

    @FXML
    private Button car_type;

    @FXML
    private Button zapchasti_type;

    @FXML
    private Button remont_type;

    @FXML
    private TextField model_car_field;

    @FXML
    private TextField year_car_field;

    @FXML
    private TextField city_car_field;

    @FXML
    private TextField price_car_field;

    @FXML
    private TextField phone_car_field;

    @FXML
    private Button car_button;

    @FXML
    private TextField type_zapchasti_field;

    @FXML
    private TextArea car_comment;

    @FXML
    private TextField year_zapchasti_field;

    @FXML
    private TextField city_zapchasti_field;

    @FXML
    private TextField car_zapchasti_field;

    @FXML
    private TextField price_zapchasti_field;

    @FXML
    private TextField phone_zapchasti_field;

    @FXML
    private TextArea zapchasti_comment;

    @FXML
    private TextArea remont_comment;

    @FXML
    private Button remonti_button;

    @FXML
    private TextField remont_type_field;

    @FXML
    private TextField city_remont_field;

    @FXML
    private TextField price_remont_field;

    @FXML
    private TextField phone_remont_field;

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem profile;

    @FXML
    private MenuItem exit;

    @FXML
    void initialize(ObjectOutputStream oos, ObjectInputStream ois, User user,Stage primaryStage) {
        primaryStage.setTitle("KOLESA");

        model_car_field.setVisible(false);
        year_car_field.setVisible(false);
        city_car_field.setVisible(false);
        price_car_field.setVisible(false);
        phone_car_field.setVisible(false);
        car_comment.setVisible(false);
        car_button.setVisible(false);

        type_zapchasti_field.setVisible(false);
        car_zapchasti_field.setVisible(false);
        year_zapchasti_field.setVisible(false);
        city_zapchasti_field.setVisible(false);
        price_zapchasti_field.setVisible(false);
        phone_zapchasti_field.setVisible(false);
        zapchasti_comment.setVisible(false);
        zapchasti_button.setVisible(false);

        remont_type_field.setVisible(false);
        remont_comment.setVisible(false);
        remonti_button.setVisible(false);
        city_remont_field.setVisible(false);
        price_remont_field.setVisible(false);
        phone_remont_field.setVisible(false);


        car_type.setOnAction(event -> {
            remont_type_field.setVisible(false);
            remont_comment.setVisible(false);
            remonti_button.setVisible(false);
            city_remont_field.setVisible(false);
            price_remont_field.setVisible(false);
            phone_remont_field.setVisible(false);


            type_zapchasti_field.setVisible(false);
            car_zapchasti_field.setVisible(false);
            year_zapchasti_field.setVisible(false);
            city_zapchasti_field.setVisible(false);
            price_zapchasti_field.setVisible(false);
            phone_zapchasti_field.setVisible(false);
            zapchasti_comment.setVisible(false);
            zapchasti_button.setVisible(false);


            model_car_field.setVisible(true);
            year_car_field.setVisible(true);
            city_car_field.setVisible(true);
            price_car_field.setVisible(true);
            phone_car_field.setVisible(true);
            car_button.setVisible(true);
            car_comment.setVisible(true);

            car_button.setOnAction(event1 -> {

                try {
                    Request req = new Request("ADD_CAR");
                    Car c  = new Car(model_car_field.getText().trim(),year_car_field.getText().trim(),city_car_field.getText().trim(),price_car_field.getText().trim(),phone_car_field.getText().trim(),car_comment.getText().trim());
                    req.setCar(c);

                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Обьявление успешно добавлено!");
                        alert.show();


                        model_car_field.deleteText(0,model_car_field.getLength());
                        year_car_field.deleteText(0,year_car_field.getLength());
                        city_car_field.deleteText(0,city_car_field.getLength());
                        price_car_field.deleteText(0,price_car_field.getLength());
                        phone_car_field.deleteText(0,phone_car_field.getLength());
                        car_comment.deleteText(0,car_comment.getLength());


                        model_car_field.setVisible(false);
                        year_car_field.setVisible(false);
                        city_car_field.setVisible(false);
                        price_car_field.setVisible(false);
                        phone_car_field.setVisible(false);
                        car_comment.setVisible(false);
                        car_button.setVisible(false);


                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });


        });

        zapchasti_type.setOnAction(event -> {
            remont_type_field.setVisible(false);
            remont_comment.setVisible(false);
            remonti_button.setVisible(false);
            city_remont_field.setVisible(false);
            price_remont_field.setVisible(false);
            phone_remont_field.setVisible(false);


            model_car_field.setVisible(false);
            year_car_field.setVisible(false);
            city_car_field.setVisible(false);
            price_car_field.setVisible(false);
            phone_car_field.setVisible(false);
            car_comment.setVisible(false);
            car_button.setVisible(false);



            type_zapchasti_field.setVisible(true);
            car_zapchasti_field.setVisible(true);
            year_zapchasti_field.setVisible(true);
            city_zapchasti_field.setVisible(true);
            price_zapchasti_field.setVisible(true);
            phone_zapchasti_field.setVisible(true);
            zapchasti_comment.setVisible(true);
            zapchasti_button.setVisible(true);

            zapchasti_button.setOnAction(event1 -> {

                try {
                    Request req  = new Request("ADD_ZAPCHASTI");
                    Zapchasti zap  =  new Zapchasti(type_zapchasti_field.getText().trim(),car_zapchasti_field.getText().trim(),year_zapchasti_field.getText().trim(),city_zapchasti_field.getText().trim(),price_zapchasti_field.getText().trim(),phone_zapchasti_field.getText().trim(),zapchasti_comment.getText().trim());
                    req.setZap(zap);


                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Обьявление успешно добавлено!");
                        alert.show();


                        type_zapchasti_field.deleteText(0,type_zapchasti_field.getLength());
                        car_zapchasti_field.deleteText(0,car_zapchasti_field.getLength());
                        year_zapchasti_field.deleteText(0,year_zapchasti_field.getLength());
                        city_zapchasti_field.deleteText(0,city_zapchasti_field.getLength());
                        price_zapchasti_field.deleteText(0,price_zapchasti_field.getLength());
                        phone_zapchasti_field.deleteText(0,phone_zapchasti_field.getLength());
                        zapchasti_comment.deleteText(0,zapchasti_comment.getLength());

                        type_zapchasti_field.setVisible(false);
                        car_zapchasti_field.setVisible(false);
                        year_zapchasti_field.setVisible(false);
                        city_zapchasti_field.setVisible(false);
                        price_zapchasti_field.setVisible(false);
                        phone_zapchasti_field.setVisible(false);
                        zapchasti_comment.setVisible(false);
                        zapchasti_button.setVisible(false);


                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

        });
        });

        remont_type.setOnAction(event -> {
            model_car_field.setVisible(false);
            year_car_field.setVisible(false);
            city_car_field.setVisible(false);
            price_car_field.setVisible(false);
            phone_car_field.setVisible(false);
            car_comment.setVisible(false);
            car_button.setVisible(false);

            type_zapchasti_field.setVisible(false);
            car_zapchasti_field.setVisible(false);
            year_zapchasti_field.setVisible(false);
            city_zapchasti_field.setVisible(false);
            price_zapchasti_field.setVisible(false);
            phone_zapchasti_field.setVisible(false);
            zapchasti_comment.setVisible(false);
            zapchasti_button.setVisible(false);

            remont_type_field.setVisible(true);
            remont_comment.setVisible(true);
            remonti_button.setVisible(true);
            city_remont_field.setVisible(true);
            price_remont_field.setVisible(true);
            phone_remont_field.setVisible(true);

            remonti_button.setOnAction(event1 -> {

                try {
                    Request req  = new Request("ADD_REMONT");
                    Remont zap  =  new Remont(remont_type_field.getText().trim(),city_remont_field.getText().trim(),price_remont_field.getText().trim(),phone_remont_field.getText().trim(),remont_comment.getText().trim());
                    req.setRem(zap);


                    oos.writeObject(req);

                    Response res =  (Response)ois.readObject();

                    System.out.println(res.getResponse());

                    if(res.getResponse().equals("SUCCESSFULLY")){
                        Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("Обьявление успешно добавлено!");
                        alert.show();


                        remont_type_field.deleteText(0,type_zapchasti_field.getLength());
                        remont_comment.deleteText(0,car_zapchasti_field.getLength());
                        city_remont_field.deleteText(0,city_remont_field.getLength());
                        price_remont_field.deleteText(0,price_remont_field.getLength());
                        phone_remont_field.deleteText(0,phone_remont_field.getLength());

                        remont_type_field.setVisible(false);
                        remont_comment.setVisible(false);
                        remonti_button.setVisible(false);
                        city_remont_field.setVisible(false);
                        price_remont_field.setVisible(false);
                        phone_remont_field.setVisible(false);

                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });


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
            menu.initialize(oos,ois, user, primaryStage);

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

    }
}
