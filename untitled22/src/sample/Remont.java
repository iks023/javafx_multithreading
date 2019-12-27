package sample;

import java.io.Serializable;

public class Remont implements Serializable {

    private Long id;
    private String typeRemont;
    private String city;
    private String price;
    private String phone;
    private String comment;


    public Remont(Long id, String typeRemont, String city, String price, String phone, String comment) {
        this.id = id;
        this.typeRemont = typeRemont;
        this.city = city;
        this.price = price;
        this.phone = phone;
        this.comment = comment;
    }

    public Remont(String typeRemont, String city, String price, String phone, String comment) {
        this.typeRemont = typeRemont;
        this.city = city;
        this.price = price;
        this.phone = phone;
        this.comment = comment;
    }

    public Remont() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeRemont() {
        return typeRemont;
    }

    public void setTypeRemont(String typeRemont) {
        this.typeRemont = typeRemont;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public String toString() {
        return " id = " + id +
                "\n Тип ремонта = " + typeRemont +
                "\n Город = " + city  +
                "\n Цена = " + price  +
                "\n Телефон = " + phone  +
                "\n Комментарий = " + comment;
    }
}