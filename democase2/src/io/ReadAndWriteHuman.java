package io;

import models.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteHuman {

    public static List<Human> readHuman() {
        try {
            File file = new File("human.txt");
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream("human.txt");

            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (List<Human>) objectInputStream.readObject();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeHuman(List<Human> humans) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("human.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(humans);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
