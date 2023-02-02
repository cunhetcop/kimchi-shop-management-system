package io;
import models.Account;

import java.io.*;
import java.util.ArrayList;


public class ReadAndWrite<E> {
    public void write(ArrayList<E> list, String path) {
        File file = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<E> read(File file){

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<E>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error!!!");
        }
        return new ArrayList<>();
    }
}
