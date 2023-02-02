package Validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {
    public static final String regexname = "[^0-9]{1,20}"; //Một chỗi dài từ 1-20 và không chấp nhận bất kì số nào từ 0-9
    public static final String regexage = "[^a-z][0-9]{1,2}"; // số 0-9 và có độ dài 1-2 và không chấp nhận chữ cái từ a-z
    public static final String regextelephone = "[+84][0-9]{3,15}";
    public static final String regexemail = "^[a-zA-Z]+[0-9_a-zA-z.]*@([a-z]+\\.[a-z]+)+";
    public static final String regexusername = "[A-Z][a-z]{1,9}[0-9]{1,9}";
    public static final String regexpassword = "[A-Za-z0-9]+";
    public static final String regexrole = "0";



    static Scanner sc = new Scanner(System.in);

    public static String name(){
        while (true){
            String Name = sc.nextLine();
            Pattern pattern = Pattern.compile(regexname);
            Matcher matcher = pattern.matcher(Name);
            if (matcher.matches()){
                return Name;
            }
            System.err.println("Tên không được chứa số");
        }
    }
    public static String age(){
        while (true){
            String Age = sc.nextLine();
            Pattern pattern = Pattern.compile(regexage);
            Matcher matcher= pattern.matcher(Age);
            if (matcher.matches()){
                return Age;
            }
            System.err.println("Tuổi phải là số, không chứa chữ cái");
        }
    }
    public static String telephone(){
        while (true){
            String Telephone = sc.nextLine();
            Pattern pattern = Pattern.compile(regextelephone);
            Matcher matcher = pattern.matcher(Telephone);
            if (matcher.matches()){
                return Telephone;

            }
            System.err.println("Sai định dạng");
        }
    }
    public static String email(){
        while (true){
            String Email = sc.nextLine();
            Pattern pattern = Pattern.compile(regexemail);
            Matcher matcher = pattern.matcher(Email);
            if (matcher.matches()){
                return Email;
            }
            System.err.println("Sai định dạng");
        }
    }
    public static String username(){
        while (true){
            String Username = sc.nextLine();
            Pattern pattern = Pattern.compile(regexusername);
            Matcher matcher = pattern.matcher(Username);
            if(matcher.matches()){
                return Username;
            }
            System.err.println("Sai định dạng");
        }
    }

    public static String password(){
        while (true){
            String Password = sc.nextLine();
            Pattern pattern = Pattern.compile(regexpassword);
            Matcher matcher= pattern.matcher(Password);
            if(matcher.matches()){
                return Password;
            }
            System.err.println("Sai định dạng");
        }
    }

    public static String role(){
        while (true){
            String role = sc.nextLine();
            Pattern pattern = Pattern.compile(regexrole);
            Matcher matcher= pattern.matcher(role);
            if(matcher.matches()){
                return role;
            }
            System.out.println("Nhấn số '0' để hoàn tất đăng ký ");
        }
    }
}
