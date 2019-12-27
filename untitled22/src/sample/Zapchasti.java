package sample;

import java.io.Serializable;

public class Zapchasti implements Serializable {

    private Long id;
    private String zapchast;
    private String car;
    private String year;
    private String city;
    private String price;
    private String phone;
    private String comment;


    public Zapchasti(Long id, String zapchast, String car, String year, String city, String price, String phone, String comment) {
        this.id = id;
        this.zapchast = zapchast;
        this.car = car;
        this.year = year;
        this.city = city;
        this.price = price;
        this.phone = phone;
        this.comment = comment;
    }

    public Zapchasti(String zapchast, String car, String year, String city, String price, String phone, String comment) {
        this.zapchast = zapchast;
        this.car = car;
        this.year = year;
        this.city = city;
        this.price = price;
        this.phone = phone;
        this.comment = comment;
    }

    public Zapchasti() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZapchast() {
        return zapchast;
    }

    public void setZapchast(String zapchast) {
        this.zapchast = zapchast;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return " id = " + id +
                "\n Тип запчасти = " + zapchast  +
                "\n Машина запчасти = " + car  +
                "\n Год = " + year  +
                "\n Город = " + city  +
                "\n Цена = " + price  +
                "\n Телефон = " + phone  +
                "\n Дополнительный комментарий = " + comment ;
    }
}
