import model.Account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registration {

    public void customerRegistration() {


        Account account = new Account();
        Scanner sc = new Scanner(System.in);

        // for name


        String regex = "[a-zA-Z]";

//        if (Pattern.matches("[a-zA-Z+]+[ ]+[a-zA-Z]{1,20}", fullName)) {
//            account.setFullName(fullName);
//        } else {
//            System.out.println("Please enter a correct name format");
//        }
        String fullName;
        do{
            System.out.println("Please enter your full name");
            fullName = sc.nextLine();
            account.setFullName(fullName);
        } while(!(Pattern.matches("[a-zA-Z+]+[ ]+[a-zA-Z]{1,20}", fullName)));

        // for account number
        GenerateAccount accountId = new GenerateAccount();
        String id = accountId.generateToken();
        account.setAccountNumber(id);


        // for email
        System.out.println("Enter your email");
        String email = sc.nextLine();

        if (Pattern.matches("[a-zA-Z0-9+_.-]+@[a-z]+[.][a-z]{3}", email)) {
            account.setEmail(email);
        } else {
            System.out.println("Please enter a correct email format");
        }

        //for phone
        System.out.println("Enter your phone number.");
        String phone = sc.nextLine();

        if (Pattern.matches("[0-9]{10}", phone)) {
            account.setPhone(phone);
        } else {
            System.out.println("Enter a correct phone format. ");
        }

        //for address
        System.out.println("Enter your address.");
        String address = sc.nextLine();

        if (Pattern.matches("[a-zA-Z]{1,30}", address)) {
            account.setAddress(address);
        } else {
            System.out.println("Enter a correct address format. ");
        }

        account.setBalance(0);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\account.csv", true));
            writer.write("\n" + account.getFullName() + ",");
            writer.write(account.getAccountNumber() + ",");
            writer.write(account.getBalance() + ",");
            writer.write(account.getEmail() + ",");
            writer.write(account.getPhone() + ",");
            writer.write(account.getAddress());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(account.getFullName());
        System.out.println(account.getAccountNumber());
        System.out.println(account.getEmail());
        System.out.println(account.getPhone());
        System.out.println(account.getAddress());
    }

}
