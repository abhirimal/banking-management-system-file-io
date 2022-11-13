import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException {

        Registration registration = new Registration();
        DisplayCustomerDetails displayCustomerDetails = new DisplayCustomerDetails();
        Transactions transactions = new Transactions();
        DisplayTransactionDetails displayTransactionDetails = new DisplayTransactionDetails();

        int option;
        Scanner input = new Scanner(System.in);
        System.out.println("!!!! Welcome to Abhiyan Development Bank !!!!\n" +
                "1. View account details. \n" +
                "2. Create new Account \n" +
                "3. Make transactions \n" +
                "4. View transactions \n" +
                "5. Exit");
        option = input.nextInt();

        switch (option) {

            case 1:
                displayCustomerDetails.display();
                break;

            case 2:
                registration.customerRegistration();
                break;

            case 3:
                System.out.println("1. Make Deposit. \n" +
                        "2. Make Withdraw. ");
                int insideOption = input.nextInt();

                // nested switch statement
                switch (insideOption) {
                    case 1:
                        transactions.makeDeposit();
                        break;
                    case 2:
                        transactions.makeWithdraw();
                        break;
                    default:
                        System.out.println("Error. Please try again");
                        break;

                }
                break;

            case 4:
                displayTransactionDetails.displayTransaction();
                break;

            case 5:
                System.out.println("Thank you for using our platform. ");
                break;

            default:
                System.out.println("Invalid");
                break;
        }

    }
}