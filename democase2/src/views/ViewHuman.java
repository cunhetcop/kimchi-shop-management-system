package views;

import models.Human;
import models.Student;
import models.Teacher;

import java.util.List;
import java.util.Scanner;

public class ViewHuman {
    Scanner scanner = new Scanner(System.in);

    public int menuUser() {
        System.out.println("1. Thêm");
        System.out.println("2. Sửa");
        System.out.println("3. Xóa");
        System.out.println("4. Show");
        System.out.println("5. Đăng xuất");
        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAdmin() {
        System.out.println("2. Sửa Account");
        System.out.println("3. Xóa Account");
        System.out.println("4. Show Account");
        System.out.println("5. Đăng xuất");
        return Integer.parseInt(scanner.nextLine());
    }


    public int menuAdd() {
        System.out.println("1. Thêm Student");
        System.out.println("2. Thêm Teacher");
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputName() {
        System.out.println("Nhập name");
        return scanner.nextLine();
    }

    public Human creteHuman(boolean isStudent) {
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập age");
        int age = Integer.parseInt(scanner.nextLine());

        if (isStudent) {
            System.out.println("Nhập avg");
            double avg = Double.parseDouble(scanner.nextLine());
            return new Student(name, age, avg);
        } else {
            System.out.println("Nhập salary");
            double salary = Double.parseDouble(scanner.nextLine());
            return new Teacher(name, age, salary);
        }
    }

    public void show(List<Human> humans){
        for (Human h:humans) {
            System.out.println(h.toString());
        }
    }
}
