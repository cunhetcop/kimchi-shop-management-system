package managers;

import IO.ReadAndWrite;
import Validate.ValidateUser;
import Views.MenuUser;
import models.AccountUser;
import models.Cat;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerUser {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    File fileUser = new File("/Users/nguyenhalinh/Applications/codegymHALINH/FINAL/module2/case_study/CaseStudy/src/File_text/user.txt");
    ArrayList<AccountUser> accountUsers;

    public ManagerUser() {
        accountUsers = readAndWrite.read(fileUser);
    }

    File fileGiohang = new File("/Users/nguyenhalinh/Applications/codegymHALINH/FINAL/module2/case_study/CaseStudy/src/File_text/giohang.txt");
    ReadAndWrite<AccountUser> readAndWrite = new ReadAndWrite<>();
    ReadAndWrite<Cat> readAndWrite2 = new ReadAndWrite<>();

    ArrayList<Cat> giohang = readAndWrite2.read(fileGiohang);

    Scanner sc = new Scanner(System.in);
    ManagerProduct managerProduct = new ManagerProduct();


    public boolean login() {
        accountUsers = readAndWrite.read(fileUser);
        try {
            System.out.println("Nhập username");
            String username = sc.nextLine();
            System.out.println("Nhập password");
            String password = sc.nextLine();
            for (int i = 0; i < accountUsers.size(); i++) {
                if (accountUsers.get(i).getUsername().equals(username) && accountUsers.get(i).getPassword().equals(password) && accountUsers.get(i).getRole().equals("0")) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void register() {
        accountUsers = readAndWrite.read(fileUser);
        System.out.println("Nhập họ và tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        String age = ValidateUser.age();
        System.out.println("Nhập số điện thoại ( bắt đầu bằng +84 ): ");
        String telephone = ValidateUser.telephone();
        System.out.println("Nhập email: ");
        String email = ValidateUser.email();
        String username;
        while (true) {
            System.out.println("Nhập username ( Bắt đầu bằng chữ in hoa và có ít nhất một số ): ");
            username = ValidateUser.username();
            if (checkUserName(username)) {
                break;
            }
            System.err.println("Trùng username");
        }
        System.out.println("Nhập password ( không phân biệt hoa-thường hay số): ");
        String password = ValidateUser.password();
        System.out.println("Nhấn số '0' để hoàn tất đăng ký");
        String role = ValidateUser.role();
        System.out.println(ANSI_GREEN);
        System.out.println("Chúc mừng bạn đã đăng ký thành công");
        System.out.println(ANSI_RESET);

        accountUsers.add(new AccountUser(name, age, telephone, email, username, password, role, giohang));
        readAndWrite.write(fileUser, accountUsers);
    }

    public void showACC() {
        accountUsers = readAndWrite.read(fileUser);
        for (int i = 0; i < accountUsers.size(); i++) {
            System.out.println(i + 1 + "." + "\n" + "ID:       " + accountUsers.get(i).getUsername() + "\n"
                    + "Password: " + accountUsers.get(i).getPassword() + "\n"
                    + "Tên:      " + accountUsers.get(i).getName() + "\n"
                    + "Tuổi:     " + accountUsers.get(i).getAge() + "\n"
                    + "SĐT:      " + accountUsers.get(i).getTelephone() + "\n"
                    + "Email     " + accountUsers.get(i).getEmail() + "\n"
                    + "Role      " + accountUsers.get(i).getRole() + "\n" +
                    "=====================");
        }
    }

    public void removeAcc() {
        accountUsers = readAndWrite.read(fileUser);
        System.out.println("Nhập username muốn xóa");
        String userremove = sc.nextLine();
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getUsername().equals(userremove)) {
                accountUsers.remove(i);
                System.out.println(ANSI_GREEN);
                System.out.println("Xóa tài khoản thành công");
                System.out.println(ANSI_RESET);
                readAndWrite.write(fileUser, accountUsers);
                return;
            }
        }
        System.err.println("Tài khoản không tồn tại");
    }

    public void uyquyenAdmin() {
        accountUsers = readAndWrite.read(fileUser);
        String usernameuyquyen = null;
        System.out.println("Nhập username muốn ủy quyền thành tài khoản quản trị: ");
        usernameuyquyen = sc.nextLine();
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getUsername().equals(usernameuyquyen)) {
                accountUsers.get(i).setRole("1");
                System.out.println(ANSI_GREEN);
                System.out.println("Ủy quyền thành công");
                System.out.println(ANSI_RESET);
                readAndWrite.write(fileUser, accountUsers);
                return;
            }
        }
        System.err.println("Không tồn tại username này");
    }

    public void tuocquyenAdmin() {
        accountUsers = readAndWrite.read(fileUser);
        String usernameuyquyen = null;
        System.out.println("Nhập username muốn tước quyền quản trị: ");
        usernameuyquyen = sc.nextLine();
        for (int i = 0; i < accountUsers.size(); i++) {
            if ((accountUsers.get(i).getUsername().equals(usernameuyquyen))) {
                accountUsers.get(i).setRole("0");
                System.out.println(ANSI_GREEN);
                System.out.println("Tước quyền thành công");
                System.out.println(ANSI_RESET);
                readAndWrite.write(fileUser, accountUsers);
                return;
            }
        }
        System.err.println("Không tồn tại username này");
    }

    public boolean checkUserName(String username) {
        accountUsers = readAndWrite.read(fileUser);
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public void buyProduct() {
        System.out.println("Nhập tên sản phẩm muốn thêm vào giỏ hàng");
        String nameCaterory = sc.nextLine();
        for (int i = 0; i < managerProduct.CatList.size(); i++) {
            if (managerProduct.CatList.get(i).getNameCat().equals(nameCaterory)) {
                giohang.add(managerProduct.CatList.get(i));
                System.out.println(ANSI_GREEN);
                System.out.println("Thêm vào giỏ hàng thành công");
                System.out.println(ANSI_RESET);
                readAndWrite.write(fileUser, accountUsers);
                readAndWrite2.write(fileGiohang, giohang);
                return;
            }
        }
        System.err.println("Không tồn tại sản phẩm này");
    }

    public void removeProduct() {
        accountUsers = readAndWrite.read(fileUser);
        System.out.println("Nhập tên sản phẩm muốn xóa khỏi giỏ hàng");
        String nameCaterory = sc.nextLine();
        for (int i = 0; i < giohang.size(); i++) {
            if (giohang.get(i).getNameCat().equals(nameCaterory)) {
                giohang.remove(giohang.get(i));
                System.out.println(ANSI_GREEN);
                System.out.println("Xóa thành công");
                System.out.println(ANSI_RESET);
                readAndWrite.write(fileUser, accountUsers);
                readAndWrite2.write(fileGiohang, giohang);
                return;
            }
        }
        System.err.println("Không tồn tại sản phẩm này");
    }

    public void showGioHang() {
        giohang = readAndWrite2.read(fileGiohang);
        for (int i = 0; i < giohang.size(); i++) {
            System.out.println(giohang.get(i));
        }
        System.out.println("Tổng tiền giỏ hàng: " + tongTien());
    }


    public double tongTien() {
        double tongTien = 0.0;

        for (int i = 0; i < giohang.size(); i++) {
            tongTien += giohang.get(i).getPrice();
        }
        return tongTien;
    }

}