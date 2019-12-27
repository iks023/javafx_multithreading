package sample;

import java.io.Serializable;

public class Request  implements Serializable {
    private String code;
    private User user;
    private Car car;
    private Long id;
    private Zapchasti zap;
    private Remont rem;

    public Request(String code, Remont rem) {
        this.code = code;
        this.rem = rem;
    }

    public Request(String code, Car car) {
        this.code = code;
        this.car = car;
    }

    public Request(String code, Long id) {
        this.code = code;
        this.id = id;
    }

    public Request(String code, User user) {
        this.code = code;
        this.user = user;
    }

    public Request(String code, Zapchasti zap) {
        this.code = code;
        this.zap = zap;
    }

    public Request(String code){
        this.code = code;
    }

    public String getRequest() {
        return code;
    }

    public void setRequest(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Zapchasti getZap() {
        return zap;
    }

    public void setZap(Zapchasti zap) {
        this.zap = zap;
    }

    public Remont getRem() {
        return rem;
    }

    public void setRem(Remont rem) {
        this.rem = rem;
    }

    @Override
    public String toString() {
        return "Request{" +
                "code='" + code + '\'' +
                ", user=" + user +
                ", id=" + id +
                '}';
    }
}
