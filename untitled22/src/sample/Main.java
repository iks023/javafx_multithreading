package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Socket socket = new Socket("127.0.0.1", 1999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Login.fxml"));
            loader.load();

            primaryStage.setTitle("KOLESA");
            Parent root = loader.getRoot();
            primaryStage.setScene(new Scene(root, 1000, 600));
            primaryStage.setResizable(false);
            primaryStage.show();

            LoginController auth = loader.getController();
            auth.initialize(oos,ois,primaryStage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
