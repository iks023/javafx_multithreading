package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    private Socket socket;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    private Connection conn;


    public ClientHandler(Socket socket, Connection conn){
        this.conn = conn;
        this.socket = socket;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Remont> getAllRemont(){
        ArrayList<Remont> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from remontlist");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String type = rs.getString("type");
                String city = rs.getString("city");
                String price = rs.getString("price");
                String phone = rs.getString("phone");
                String comment = rs.getString("comment");

                list.add(new Remont(id,type,city,price,phone,comment));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addRemont(Remont zap){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO remontlist (id,type,city,price,phone,comment) VALUES(NULL, ?, ?,?,?,?)");
            ps.setString(1,zap.getTypeRemont());
            ps.setString(2,zap.getCity());
            ps.setString(3,zap.getPrice());
            ps.setString(4,zap.getPhone());
            ps.setString(5,zap.getComment());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeRemont(Long id){
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM remont where id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Zapchasti> getAllZapchasti(){
        ArrayList<Zapchasti> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from zapchastilist");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String zapchasti = rs.getString("zapchasti");
                String car = rs.getString("car");
                String year = rs.getString("year");
                String city = rs.getString("city");
                String price = rs.getString("price");
                String phone = rs.getString("phone");
                String comment = rs.getString("comment");


                list.add(new Zapchasti(id,zapchasti,car, year, city,price,phone,comment));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addZapchasti(Zapchasti zap){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO zapchastilist (id, zapchasti,car, year, city,price,phone,comment) VALUES(NULL, ?, ?, ?,?,?,?,?)");
            ps.setString(1, zap.getZapchast());
            ps.setString(2, zap.getCar());
            ps.setString(3, zap.getYear());
            ps.setString(4, zap.getCity());
            ps.setString(5,zap.getPrice());
            ps.setString(6,zap.getPhone());
            ps.setString(7,zap.getComment());


            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeZapchasti(Long id){
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM zapchastilist where id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getAllCars(){
        ArrayList<Car> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from carslist");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String mod = rs.getString("model");
                String year = rs.getString("year");
                String city = rs.getString("city");
                String price = rs.getString("price");
                String phone = rs.getString("phone");
                String comment = rs.getString("comment");


                list.add(new Car(id, mod, year, city,price,phone,comment));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addCar(Car car){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO carslist (id, model, year, city,price,phone,comment) VALUES(NULL, ?, ?, ?,?,?,?)");
            ps.setString(1, car.getModel());
            ps.setString(2, car.getYear());
            ps.setString(3, car.getCity());
            ps.setString(4,car.getPrice());
            ps.setString(5,car.getPhone());
            ps.setString(6,car.getComment());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeCar(Long id){
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM carslist where id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }



    public ArrayList<User> getAllUsers(){
        ArrayList<User> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from new_users");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String city = rs.getString("city");
                String gender = rs.getString("gender");
                String role = rs.getString("role");

                list.add(new User(id, login, password,name,surname,city,gender,role));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addUser(User user){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO new_users (id,name,surname,city,password,login,gender,role) VALUES(NULL, ?, ?,?,?,?,?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getSurname());
            ps.setString(3,user.getCity());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getGender());
            ps.setString(7, user.getRole());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addAdmin(User user){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO new_users (id,name,surname,city,password,login,gender,role) VALUES(NULL, ?, ?,?,?,?,?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getSurname());
            ps.setString(3,user.getCity());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getGender());
            ps.setString(7, user.getRole());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





    public void updateUser(User user){
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE new_users SET name=?,surname=?,city=?,password=?,login=?,role=? WHERE id = ?");
            ps.setString(1,user.getName());
            ps.setString(2,user.getSurname());
            ps.setString(3,user.getCity());
            ps.setString(4,user.getPassword());
            ps.setString(5,user.getLogin());
            ps.setString(6,user.getRole());
            ps.setLong(7, user.getId());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUser(Long id){
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM new_users where id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            Request req = null;
            try {
                req = (Request)ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            assert req != null;

            switch (req.getRequest().toUpperCase()) {
                case "REGISTRATION":{
                    Response res = null;
                    try {
                        addUser(req.getUser());
                        res = new Response("SUCCESSFULLY");
                    } catch (Exception e) {
                        res = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "AUTH": {
                    Response rep = new Response();
                    User user = req.getUser();
                    boolean b = true;
                    for (User u: getAllUsers()) {
                        if(u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword()) && u.getRole().equals("customer")){
                            rep.setUser(u);
                            rep.setResponse("SUCCESSFULLY");
                            b=false;
                        }
                        if(u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword()) && u.getRole().equals("admin")){
                            rep.setUser(u);
                            rep.setResponse("ADMIN");
                            b=false;
                        }
                    }
                    if(b){
                        rep.setResponse("NOT FOUND");
                    }
                    try {
                        oos.writeObject(rep);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                }
                case "ADD_CAR":{
                    Response res2 = null;
                    try {
                        addCar(req.getCar());
                        res2 = new Response("SUCCESSFULLY");
                    } catch (Exception e) {
                        res2 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ADD_ZAPCHASTI":{
                    Response res3 = null;
                    try {
                        addZapchasti(req.getZap());
                        res3 = new Response("SUCCESSFULLY");
                    } catch (Exception e) {
                        res3 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ADD_REMONT":{
                    Response res4 = null;
                    try {
                        addRemont(req.getRem());
                        res4 = new Response("SUCCESSFULLY");
                    } catch (Exception e) {
                        res4 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res4);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "REMOVE_USER":{
                    Response res5 = null;
                    try {
                        removeUser(req.getUser().getId());
                        res5 = new Response("SUCCESSFULLY");
                    } catch (Exception e) {
                        res5 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res5);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "GET_USER":{
                    Response rep6 = new Response();
                    User user = req.getUser();
                    for (User u: getAllUsers()) {
                        if(u.getId().equals(user.getId())){
                            rep6.setUser(u);
                            rep6.setResponse("SUCCESSFULLY");
                        }
                    }
                    try {
                        oos.writeObject(rep6);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                    }
                case "UPDATE_USER":{
                    Response res6 = null;
                    try {
                        updateUser(req.getUser());
                        res6 = new Response("SUCCESSFULLY");
                    } catch (Exception e) {
                        res6 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res6);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ALL_USER":{
                    Response res7 = null;
                    try {
                        ArrayList<User>u = new ArrayList<>();
                        res7 = new Response("SUCCESSFULLY");

                        res7.setAllusers(getAllUsers());

                    } catch (Exception e) {
                        res7 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res7);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ALL_CAR":{
                    Response res8 = null;
                    try {
                        res8 = new Response("SUCCESSFULLY");
                        res8.setCars(getAllCars());

                    } catch (Exception e) {
                        res8 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ALL_ZAPCHASTI":{
                    Response res9 = null;
                    try {
                        res9 = new Response("SUCCESSFULLY");
                        res9.setZapchastis(getAllZapchasti());

                    } catch (Exception e) {
                        res9 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res9);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ALL_REMONT":{
                    Response res11 = null;
                    try {
                        res11 = new Response("SUCCESSFULLY");
                        res11.setRemonts(getAllRemont());

                    } catch (Exception e) {
                        res11 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res11);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "REMOVE_CAR":{
                    Response res12 = null;
                    try {
                        removeCar(req.getCar().getId());
                        res12 = new Response("SUCCESSFULLY");

                    } catch (Exception e) {
                        res12 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res12);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "REMOVE_ZAP":{
                    Response res13 = null;
                    try {
                        removeZapchasti(req.getZap().getId());
                        res13 = new Response("SUCCESSFULLY");

                    } catch (Exception e) {
                        res13 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res13);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "REMOVE_REM":{
                    Response res13 = null;
                    try {
                        removeRemont(req.getRem().getId());
                        res13 = new Response("SUCCESSFULLY");

                    } catch (Exception e) {
                        res13 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res13);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ADD_ADMIN":{
                    Response res14 = null;
                    try {
                        addAdmin(req.getUser());
                        res14 = new Response("SUCCESSFULLY");

                    } catch (Exception e) {
                        res14 = new Response(e.getMessage());
                    }
                    try {
                        oos.writeObject(res14);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
