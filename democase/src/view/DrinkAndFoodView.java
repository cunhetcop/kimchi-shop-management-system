package view;

import java.util.Scanner;

public class DrinkAndFoodView {
    Scanner scanner = new Scanner(System.in);
    public int menuDrinkAndFood(){
        while (true){
            try{
                System.out.println("------Menu Drink and Food------");
                System.out.println("1.Add Drink and Food");
                System.out.println("2.Edit Drink and Food");
                System.out.println("3.Delete Drink and Food");
                System.out.println("4.Display All");
                System.out.println("5.Exit");
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Please enter number");
            }
        }
    }
}
