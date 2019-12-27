package sample;

import java.io.Serializable;

public class User implements Serializable {
    private Long id = null;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String gender;
    private String role;

    public User(Long id, String login, String password, String name, String surname, String city, String gender, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.gender = gender;
        this.role = role;
    }


    public User(String login, String password, String name, String surname, String city, String gender, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.gender = gender;
        this.role = role;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return " id = " + id +
                "\n Логин = " + login +
                "\n Пароль = " + password+
                "\n Имя = " + name  +
                "\n Фамилие = " + surname  +
                "\n Город = " + city  +
                "\n Пол = " + gender+
                "\n Роль = " + role ;
    }
}
