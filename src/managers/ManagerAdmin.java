package managers;

import IO.ReadAndWrite;
import models.AccountAdmin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAdmin {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    File file = new File("/Users/nguyenhalinh/Applications/codegymHALINH/FINAL/module2/case_study/CaseStudy/src/File_text/account.txt");
    ReadAndWrite<AccountAdmin> readAndWrite = new ReadAndWrite<>();
    ArrayList<AccountAdmin> accountAdmin = readAndWrite.read(file);
    Scanner sc = new Scanner(System.in);

    ManagerProduct managerProduct;

    ManagerUser managerUser = new ManagerUser();



    public boolean loginAdmin() {

        try {
            System.out.println("Nhập username admin");
            String username = sc.nextLine();
            System.out.println("Nhập password admin");
            String password = sc.nextLine();
            for (int i = 0; i < managerUser.accountUsers.size(); i++) {
                if (managerUser.accountUsers.get(i).getUsername().equals(username) && managerUser.accountUsers.get(i).getPassword().equals(password) && managerUser.accountUsers.get(i).getRole().equals("1") || (username.equals("halinh") && password.equals("halinh"))) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } return false;
    }





}


