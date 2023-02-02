package Views;

import managers.ManagerAdmin;
import managers.ManagerProduct;
import managers.ManagerUser;

import java.util.Scanner;

public class MenuUser {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    Scanner sc = new Scanner(System.in);
    ManagerUser managerUser = new ManagerUser();

    MenuAdmin menuAdmin = new MenuAdmin();

    ManagerProduct managerProduct = new ManagerProduct();

    public void menuUser() {
        if (managerUser.login()) {
            System.out.println(ANSI_GREEN);
            System.out.println("Đăng nhập user thành công");
            System.out.println(ANSI_RESET);
            while (true) {
                System.out.println("╔===================================================╗");
                System.out.println("║       ▂ ▃ ▅ ▆ █ GIAO DIỆN NGƯỜI DÙNG █ ▆ ▅ ▃ ▂    ║");
                System.out.println("╠===================================================╣");
                System.out.println("║[1]. Hiển thị danh sách sản phẩm                   ║");
                System.out.println("║[2]. Thêm Sản Phẩm vào giỏ hàng                    ║");
                System.out.println("║[3]. Xóa Sản Phẩm                                  ║");
                System.out.println("║[4]. Hiển thị sản phẩm và tổng tiền                ║");
                System.out.println("║[0]. Thoát                                         ║");
                System.out.println("║                                                   ║");
                System.out.println("╚===================================================╝");
                System.out.println("Nhập lựa chọn:");
                try {
                    int choice1 = Integer.parseInt(sc.nextLine());
                    if (choice1 < 0 || choice1 > 4) {
                        System.out.println();
                        System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                    }

                    switch (choice1) {
                        case 1:
                            managerProduct.showCat();
                            break;
                        case 2:
                            managerUser.buyProduct();
                            break;
                        case 3:
                            managerUser.removeProduct();
                            break;
                        case 4:
                            managerUser.showGioHang();
                            break;
                        case 0:
                            return;
                    }
                } catch (Exception e) {
                    System.err.println("Nhập lại !!!");

                }

            }

        } else {
            System.err.println("Tài khoản không tồn tại");
        }
    }
}