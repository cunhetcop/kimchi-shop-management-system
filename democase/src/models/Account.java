package models;

import java.io.Serializable;

public class Account implements Serializable {

    private String name;
    private String userName;
    private String passWord;
    private String email;

    public Account() {
    }

    public Account(String name, String userName, String passWord, String email, String rights) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public Account(String name, String userName, String passWord, String email) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
