package controllers;
import io.ReadAndWrite;
import models.Account;
import models.user;
import view.AccountView;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAccount {
    Scanner scanner = new Scanner(System.in);
    File file = new File("Account.txt");
    ReadAndWrite readAndWrite = new ReadAndWrite();
    ArrayList<Account> ListAccount = readAndWrite.read(file);

    AccountView accountView = new AccountView();

    public void Login() {
        System.out.println("Moi ban nhap ten dang nhap");
        String name = scanner.nextLine();
        System.out.println("nhap password");
        String pass = scanner.nextLine();
        int i = 0;
        while (i < ListAccount.size()) {
            if (name == ListAccount.get(i).getUserName() && pass == ListAccount.get(i).getPassWord()) {
                if (ListAccount.get(i) instanceof user) {

                } else {
                    accountView.menuAccount();
//                    quanlyuser, san pham
                }
            } else {
                System.out.println("Nhap lai");
                Login();
                return;
            }
            i++;
        }
    }

    public void addAcc(){
        System.out.println("Nhap ten");
        String name = scanner.nextLine();
        System.out.println("Nhap ten account");
        String userName = scanner.nextLine();
        System.out.println("Nhap mat khau");
        String passWord = scanner.nextLine();
        System.out.println("Nhap email");
        String email = scanner.nextLine();

        Account account = new Account(name,userName,passWord,email);
        ListAccount.add(account);
        readAndWrite.write(ListAccount,"Account.txt");
    }

    public void editAcc(){
        System.out.println("nhap ten account can sua");
        String userName = scanner.nextLine();
        for ( int i=0; i<ListAccount.size();i++){
            if(userName.equals(ListAccount.get(i).getUserName())){
                System.out.println("nhap ten");
                ListAccount.get(i).getName();
                System.out.println("nhap email");
                ListAccount.get(i).getEmail();
                System.out.println("nhap username");
                ListAccount.get(i).getUserName();
                System.out.println("nhap password");
                ListAccount.get(i).getPassWord();
            }
        }
    }

    public void delete(){
        System.out.println("nhap ten userName can xoa");
        String userName = scanner.nextLine();
        for(int i = 0; i<ListAccount.size(); i++){
            if(userName.equals(ListAccount.get(i).getUserName())){
                ListAccount.remove(i);
            }
        }
    }

    public void show1(){
        for (Account x:ListAccount) {
            System.out.println(x.toString());

        }
    }
}