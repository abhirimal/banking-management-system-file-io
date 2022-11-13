import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DisplayTransactionDetails {

    public void displayTransaction() {

        System.out.println("Enter your account number. ");
        Scanner input = new Scanner(System.in);
        String accountNumber = input.nextLine();

        String line = " ";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\transactions.csv"));
            while ((line = br.readLine()) != null) {

                if (line.contains(accountNumber)) {
                    String[] account = line.split(splitBy);
                    //use comma as separator
                    System.out.println(" Account =" + account[0] +
                            "\n Trsancation Type= " + account[1] +
                            "\n Amount = " + account[2] +
                            "\n Time= " + account[3]+
                            "\n");
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
