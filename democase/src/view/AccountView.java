package view;

import java.util.Scanner;

import static java.nio.file.Files.delete;

public class AccountView {
    Scanner scanner = new Scanner(System.in);
    public void menuAccount(){
        int choice = 0;
        
        while(true) {
                System.out.println("---------Menu Account---------");
                System.out.println("1.Add account");
                System.out.println("2.Edit account");
                System.out.println("3.Delete account");
                System.out.println("4.Display all");
                System.out.println("5.Exit");
                
                try {  choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Please enter number");
            }
                switch (choice){
                    case 1:
                        addAcc();
                        break;
                    case 2:
                        editAcc();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        show1();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                        
                }
        }
    }

    private void show1() {
    }

    private void delete() {
    }

    private void editAcc() {
    }

    private void addAcc() {
    }
}
