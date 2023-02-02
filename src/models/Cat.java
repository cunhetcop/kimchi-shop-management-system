package models;

import java.io.Serializable;

public class Cat implements Serializable {
    private int idCat;
    private String nameCat;

    private int price;
    private int amount;
    private String describe;

    public Cat() {
    }

    public Cat(int idCat, String nameCat, int price, int amount, String describe) {
        this.idCat = idCat;
        this.nameCat = nameCat;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return
                "ID=" + idCat + ", Tên Mèo= '" + nameCat + '\'' + ", Giá= " + price + ", Số lượng= " + amount + ", Mô tả= '" + describe + '\'';
    }
}
