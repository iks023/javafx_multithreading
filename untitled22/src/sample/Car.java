package sample;


import java.io.Serializable;

public class Car implements Serializable {
    private Long id;
    private String model;
    private String year;
    private String city;
    private String price;
    private String phone;
    private String comment;

    public Car() {}

    public Car(Long id, String model, String year, String city, String price, String phone, String comment) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.city = city;
        this.price = price;
        this.phone = phone;
        this.comment = comment;
    }

    public Car(String model, String year, String city, String price, String phone, String comment) {
        this.model = model;
        this.year = year;
        this.city = city;
        this.price = price;
        this.phone = phone;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " id = " + id +
                "\n Модель = " + model  +
                "\n Год = " + year +
                "\n Город = "  + city +
                "\n Цена = " + price +
                "\n Телефон = " + phone  +
                "\n Комментарий = " + comment ;
    }
}

