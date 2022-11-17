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
        String fullName;
        do{
            System.out.println("Please enter your full name with correct format.");
            fullName = sc.nextLine();
            account.setFullName(fullName);
        } while(!(Pattern.matches("[a-zA-Z+]+[ ]+[a-zA-Z]+", fullName)));

        // for account number
        GenerateAccount accountId = new GenerateAccount();
        String id = accountId.generateToken();
        account.setAccountNumber(id);

        String email;
        do{
            System.out.println("Please enter your email with correct format.");
            email = sc.nextLine();
            account.setEmail(email);
        }
        while(!(Pattern.matches("[a-zA-Z0-9+_.-]+@[a-z]+[.][a-z]{3}", email)));

        //for phone
        String phone;
        do {
            System.out.println("Please enter your phone number with correct format.");
            phone = sc.nextLine();
            account.setPhone(phone);
        } while(!(Pattern.matches("[0-9]{10}", phone)));

        //for address

        String address;
        do {
            System.out.println("Please enter your address.");
            address = sc.nextLine();
            account.setAddress(address);
        } while ((Pattern.matches("[a-zA-Z]{1,100}", address)));

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

        System.out.println("Your account has been created. Thank You");

    }

}
