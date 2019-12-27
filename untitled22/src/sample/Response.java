package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Response  implements Serializable {
    private String code;
    private User user = null;
    private ArrayList<User>allusers = null;
    private ArrayList<Car>cars = null;
    private ArrayList<Zapchasti>zapchastis = null;
    private ArrayList<Remont>remonts=null;

    public Response(String code, User user) {
        this.code = code;
        this.user = user;
    }


    public Response() {

    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Zapchasti> getZapchastis() {
        return zapchastis;
    }

    public void setZapchastis(ArrayList<Zapchasti> zapchastis) {
        this.zapchastis = zapchastis;
    }

    public ArrayList<Remont> getRemonts() {
        return remonts;
    }

    public void setRemonts(ArrayList<Remont> remonts) {
        this.remonts = remonts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Response(String code) {
        this.code = code;
    }

    public String getResponse() {
        return code;
    }

    public void setResponse(String code) {
        this.code = code;
    }

    public ArrayList<User> getAllusers() {
        return allusers;
    }

    public void setAllusers(ArrayList<User> allusers) {
        this.allusers = allusers;
    }
}
