package models;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountUser implements Serializable {
    private String name;
    private  String age;
    private String telephone;
    private String email;
    private String username;
    private String password;
    private String role;
    private ArrayList<Cat> giohang;


    public AccountUser() {
    }

    public AccountUser(String name, String age, String telephone, String email, String username, String password, String role, ArrayList<Cat> giohang) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.giohang = giohang;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Cat> getGiohang() {
        return giohang;
    }

    public void setGiohang(ArrayList<Cat> giohang) {
        this.giohang = giohang;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", giohang=" + giohang +
                '}';
    }
}
