package view;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);

    public int menuUser() {
        int choice = 0;

        while (true) {

            System.out.println("---------Menu Account---------");
            System.out.println("1.Chon mon");
            System.out.println("2.Xoa mon");
            System.out.println("3.Tinh tien");
            System.out.println("4.Exit");
            try {
                Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Please enter number");
            }


        switch (choice) {
            case 1:
                chon();
                break;
            case 2:
                xoa();
                break;
            case 3:
                tien();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

}

    private void tien() {
    }

    private void xoa() {
    }

    private void chon() {
    }

}
