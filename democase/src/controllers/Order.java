package controllers;

import io.ReadAndWrite;
import models.DrinkandFood;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    ControllerDrinkAndFood controllerDrinkAndFood = new ControllerDrinkAndFood();
    File file = new File("D&F.txt");
    ReadAndWrite readAndWrite = new ReadAndWrite();

    ArrayList<DrinkandFood> ListProduct = readAndWrite.read(file);
    ArrayList<DrinkandFood> orders = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    public void chon(){
        controllerDrinkAndFood.show();
        System.out.println("lua chon");
        String c = scanner.nextLine();



        int i= 0;
        while (i<ListProduct.size()){
            if (c.equals(ListProduct.get(i).getId())){
                orders.add(ListProduct.get(i));
            }
            i++;
        }
    }

    public void tien(){
        double sum =0;
        int i =0;
        while (i< orders.size()){
           sum +=  orders.get(i).getPrice();
            i++;
        }
    }

    public void xoa(){
        System.out.println("nhap id mon muon xoa");
        String id = scanner.nextLine();
        for(int i=0; i<orders.size();i++){
            if(id.equals(orders.get(i).getId())) {
                orders.remove(i);
            }
            return;
        }
        System.out.println("Khong tim thay san pham");
    }
}
