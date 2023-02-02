package managers;

import IO.ReadAndWrite;
import Validate.ValidateUser;
import models.Cat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerProduct {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    File fileProduct = new File("/Users/nguyenhalinh/Applications/codegymHALINH/FINAL/module2/case_study/CaseStudy/src/File_text/product.txt");
    ReadAndWrite<Cat>readAndWrite  = new ReadAndWrite<>();
    ArrayList<Cat> CatList = readAndWrite.read(fileProduct);
    Scanner sc = new Scanner(System.in);

//    public void showCat(){
//        for (Cat cat : CatList) {
//            System.out.println(cat.toString());
//        }
//    }

    public void showCat(){
        for (int i = 0; i < CatList.size(); i++) {
            System.out.println(i+1+"."+CatList.get(i).toString());
        }
    }

    public void add(){
        Cat cat = create();
        CatList.add(cat);
        readAndWrite.write(fileProduct, CatList);
    }
    public int findIndexById(int id) {
        for (int i = 0; i < CatList.size(); i++) {
            if (CatList.get(i).getIdCat() == id) {
                return i;
            }
        }
        return -1;
    }

    public void timkiemSP(){

    }

    public Cat create() {
        int  idProduct;
        int index;
        while (true) {
            try{
                System.out.println("Nhập id :");
                idProduct = Integer.parseInt(sc.nextLine());
                index = findIndexById( idProduct);
                if (index == -1) {
                    break;
            }

            } catch (Exception e){
                System.err.println("ID phải là một số nguyên");
                continue;
            }
            System.err.println("Nhập trùng id rồi.");
        }

                String nameCaterory =null;
                System.out.println("Nhập name");
                nameCaterory = ValidateUser.name();

        int price;
        while (true) {
            try {
                System.out.println("Nhập giá");
                price = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Giá sản phẩm là số, không được chứa chữ");
                continue;
            } break;
        }
        int amount;
        while (true) {
            try {
                System.out.println("Nhập số lượng");
                amount = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("Số lượng là số nguyên, không được chứa chữ");
                continue;
            } break;
        }

        System.out.println("nhập mô tả");
        String  describe = sc.nextLine();

        Cat cat = new Cat(idProduct,nameCaterory,price,amount,describe);
        System.out.println(cat);
        return cat;

    }

    public void edit() {
        CatList = readAndWrite.read(fileProduct);
        int IDproduct;
        while (true) {
            try {
                System.out.println("Nhập ID sản phẩm muốn sửa: ");
                IDproduct = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("ID chỉ là số nguyên, không chứa chữ cái");
            }
        }
        for (int i = 0; i < CatList.size(); i++) {
                if (CatList.get(i).getIdCat() == IDproduct) {
                    CatList.set(i, create());
                    System.out.println(ANSI_GREEN);
                    System.out.println("Cập nhật thành công");
                    System.out.println(ANSI_RESET);
                    readAndWrite.write(fileProduct, CatList);
                    return;
                }
            }
        System.err.println("Không tồn tại ID này");
        }

    public void deleteProduct(){
        CatList = readAndWrite.read(fileProduct);
        int IDproduct;
        while (true) {
            try {
                System.out.println("Nhập ID sản phẩm bạn muốn xóa: ");
                IDproduct = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("ID chỉ là số nguyên, không chứa chữ cái");
            }
        }
        for (int i = 0; i < CatList.size() ; i++) {
            if (CatList.get(i).getIdCat() == IDproduct){
                CatList.remove(i);
                System.out.println(ANSI_GREEN);
                System.out.println("Xóa thành công");
                System.out.println(ANSI_RESET);
                readAndWrite.write(fileProduct, CatList);
                return;
            }
        }
        System.err.println("Không tồn tại ID này");
    }
    public void priceMaxToMin() {
        Comparator<Cat> com1 = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1.getPrice() < o2.getPrice()){
                    return -1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        };
        Collections.sort(CatList,com1);
        Collections.reverse(CatList);
        this.showCat();
    }
    public void priceMinToMax() {
        Comparator<Cat> com1 = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1.getPrice()> o2.getPrice()){
                    return -1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        };
        Collections.sort(CatList,com1);
        Collections.reverse(CatList);
        this.showCat();
    }
    public void timSP(){
        String tenSP;
        System.out.println("Nhập tên sản phẩm muốn tìm");
        tenSP = sc.nextLine();
        for (int i = 0; i < CatList.size(); i++) {
            if (CatList.get(i).getNameCat().contains(tenSP)){
                System.out.println(CatList.get(i).toString());
                return;
            }
        }
        System.err.println("Không tồn tại trong danh sách");
    }
}
