package view;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    public int LoginView() {
        while (true) {
            try {
                System.out.println("---------Menu Login---------");
                System.out.println("1.Login");
                System.out.println("2.Register");
                System.out.println("3.Exit");
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Please enter number");
            }
        }
    }
}
