import model.DateAndTime;
import model.TransactionDetails;

import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Scanner;

public class Transactions {

    DateAndTime timeStamp = new DateAndTime();

    public void makeDeposit() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your account number. ");
        String accountNumber = input.nextLine();

        System.out.println("Please enter the amount you want to deposit.");
        int deposit = input.nextInt();


        File oldFile = new File("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\account.csv");
        File tempFile = new File("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\tempAccount.csv");
        String line = " ";
        String splitBy = ",";
        String updatedAmount = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(oldFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            while ((line = reader.readLine()) != null) {
                String[] splittedAccountDetails = line.split(splitBy);

                if (splittedAccountDetails[1].contains(accountNumber)) {

                    updatedAmount = String.valueOf(Integer.parseInt(splittedAccountDetails[2]) + deposit);

                    line = splittedAccountDetails[0] + "," + splittedAccountDetails[1] + "," + updatedAmount + "," +
                            splittedAccountDetails[3] + "," + splittedAccountDetails[4]+","+splittedAccountDetails[5];
                }
                writer.write(line);
                writer.write("\n");
                writer.flush();
            }
            System.out.println(timeStamp.TimeStamp());

            reader.close();
            writer.close();

            oldFile.delete();
            tempFile.renameTo(oldFile);

            TransactionDetails transactionDetails = new TransactionDetails();
            transactionDetails.setType("Deposit");
            transactionDetails.setAccountNumber(accountNumber);
            transactionDetails.setAmount(deposit);
            transactionDetails.setTimeStamp(timeStamp.TimeStamp());

            saveTransactionDetail(transactionDetails);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void makeWithdraw() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your account number. ");
        String accountNumber = input.nextLine();

        System.out.println("Please enter the amount you want to withdraw.");
        int withdraw = input.nextInt();


        File oldFile = new File("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\account.csv");
        File tempFile = new File("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\tempAccount.csv");
        String line = " ";
        String splitBy = ",";
        String updatedAmount = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(oldFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            while ((line = reader.readLine()) != null) {
                String[] splittedAccountDetails = line.split(splitBy);

                if (splittedAccountDetails[1].contains(accountNumber)) {
                    int currentBalance = Integer.parseInt(splittedAccountDetails[2]);
                    if (currentBalance > withdraw) {
                        updatedAmount = String.valueOf(currentBalance - withdraw);

                        line = splittedAccountDetails[0] + "," + splittedAccountDetails[1] + "," + updatedAmount + "," +
                                splittedAccountDetails[3] + "," + splittedAccountDetails[4]+","+splittedAccountDetails[5];
                    } else {
                        System.out.println("You have insufficient balance.");
                    }

                }
                writer.write(line);
                writer.write("\n");
                writer.flush();
            }

            reader.close();
            writer.close();

            oldFile.delete();
            tempFile.renameTo(oldFile);

            TransactionDetails transactionDetails = new TransactionDetails();
            transactionDetails.setType("Withdraw");
            transactionDetails.setAccountNumber(accountNumber);
            transactionDetails.setAmount(withdraw);
            transactionDetails.setTimeStamp(timeStamp.TimeStamp());

            saveTransactionDetail(transactionDetails);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveTransactionDetail (TransactionDetails transactionDetails) {

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\abhir\\Desktop\\D Drive\\Click2Career Projects\\Banking-Management-System\\src\\files\\transactions.csv", true));
            writer.write("\n"+transactionDetails.getAccountNumber()+","+
                    transactionDetails.getType()+","+
                    transactionDetails.getAmount()+","+
                    transactionDetails.getTimeStamp());
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
