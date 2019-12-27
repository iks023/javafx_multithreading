package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerApp {

    private Connection conn = null;
    private ServerSocket ss = null;

    public ServerApp(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            ss = new ServerSocket(1999);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        while(true){
            try {
                System.out.println("waiting for a client...");
                Socket socket = ss.accept();
                System.out.println("client connected " + socket.getInetAddress().getHostAddress());
                ClientHandler ch = new ClientHandler(socket, conn);
                ch.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ServerApp sa = new ServerApp();
        sa.start();
    }
}