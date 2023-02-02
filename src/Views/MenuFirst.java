package Views;

import managers.ManagerAdmin;
import managers.ManagerUser;

import java.util.Scanner;

public class MenuFirst {
    Scanner sc = new Scanner(System.in);
    MenuAdmin menuAdmin = new MenuAdmin();
    MenuUser menuUser = new MenuUser();
    ManagerUser managerUser = new ManagerUser();

    ManagerAdmin managerAdmin = new ManagerAdmin();

    public void menufirst(){
            do {
                String menu= """
                        *******  ******** *********  ********   ********   ********   ****
                        *******  ******** *********  ********   ********   ********  *****
                        **       **    **      ***   **    **   **    **   **       **  **
                        **       **    **     ***         ***        ***   **   ***     **
                        **       **    **    ***        ***        ***     **   ***     **
                        **       **    **   ***        ***        ***      **    **     **
                        *******  ********  ***       ********   ********   ********   ******
                        *******  ********  ***       ********   ********   ********   ******
                                                
                                                
                        **    **    **      **       **  **     **  **    **
                        **    **    **      **       **  ***    **  **    **
                        **    **   ****     **       **  ****   **  **    **
                        ********   *  *     **       **  *****  **  ********
                        ********  ******    **       **  **  *****  ********
                        **    **  **   **   **       **  **   ****  **    **
                        **    **  *     *   *******  **  **    ***  **    **
                        **    ** **     **  *******  **  **     **  **    **
                        """;
                System.out.println(menu);
                System.out.println("╔===================================================╗");
                System.out.println("║         CHÀO MỪNG ĐẾN VỚI TRAI MÈO KIMCHI         ║");
                System.out.println("╠===================================================╣");
                System.out.println("║[1]. ĐĂNG NHẬP                                     ║");
                System.out.println("║[2]. ĐĂNG KÝ                                       ║");
                System.out.println("║[3]. ĐĂNG NHẬP QUẢN TRỊ VIÊN                       ║");
                System.out.println("║[0]. THOÁT                                         ║");
                System.out.println("╚===================================================╝");
                System.out.println("Nhập lựa chọn:");
                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    if (choice < 0 || choice > 3) {
                        System.out.println();
                        System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                    }
                switch (choice) {
                    case 1:
                        menuUser.menuUser();
                        break;
                    case 2:
                        managerUser.register();
                        break;
                    case 3:
                        menuAdmin.menuAdmin();
                        break;
                    case 0:
                       return;
                }

            } catch (NumberFormatException e) {
                    e.printStackTrace();
                } ;
        } while (true);
    }
}
