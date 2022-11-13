import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DisplayCustomerDetails {

    public void display() {

        System.out.println("Enter your account number. ");
        Scanner input = new Scanner(System.in);
        String accountNumber = input.nextLine();

        String line = " ";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\account.csv"));
            while ((line = br.readLine()) != null) {

                if (line.contains(accountNumber)) {
                    String[] account = line.split(splitBy);
                    //use comma as separator
                    System.out.println(" Full Name=" + account[0] +
                            "\n Account Number= " + account[1] +
                            "\n Balance= " + account[2] +
                            "\n Email= " + account[3] +
                            "\n Phone Number = " + account[4] +
                            "\n Address  = " + account[5]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}