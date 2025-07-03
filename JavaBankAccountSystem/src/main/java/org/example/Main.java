package org.example;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    private static BankAccount lookForAccount(ArrayList<BankAccount> bankAccounts, int accountNumber){

        for (int i =0; i < bankAccounts.size(); i++){
            if(bankAccounts.get(i).getAccountNumber() == accountNumber){
                return bankAccounts.get(i);
            }
        }

        return null;
    }

    private static void createAccount(ArrayList<BankAccount> bankAccounts){

        System.out.printf("\n" + "Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        System.out.printf("\n" + "Enter Holder Name: ");
        String accountName = scanner.next();

        System.out.printf("\n" + "Initial deposit? (yes/no): ");
        String initialDepositChoice = scanner.next();

        if (initialDepositChoice.equalsIgnoreCase("no")){
            BankAccount account = new BankAccount();
            account.setAccountNumber(accountNumber);
            account.setAccountName(accountName);
            bankAccounts.add(account);
        }
        else{
            while(true){
                System.out.printf("\n" + "Enter initial deposit amount: ");
                double initialDeposit = scanner.nextDouble();

                if (initialDeposit < 0){
                    continue;
                }

                BankAccount account = new BankAccount();
                account.setAccountNumber(accountNumber);
                account.setAccountName(accountName);
                account.deposit(initialDeposit);
                bankAccounts.add(account);

                break;
            }
        }

        System.out.println("Account created successfully");
    }

    private static void viewAccounts(ArrayList<BankAccount> bankAccounts){
        for (int i = 0; i < bankAccounts.size(); i++ ){
            bankAccounts.get(i).displayInformation();
        }
    }

    private static void checkBalance(ArrayList<BankAccount> bankAccounts){
        while (true){
            System.out.printf("\n" + "Enter Account Number: ");
            int accountNumber = scanner.nextInt();

            BankAccount foundAccount = lookForAccount(bankAccounts, accountNumber);

            if(foundAccount != null){
                foundAccount.displayInformation();
                break;
            }

            System.out.println("Invalid Account Number!");
        }
    }

    private static void depositToAccount(ArrayList<BankAccount> bankAccounts){

        while(true){
            System.out.printf("\n" + "Enter Account Number: ");
            int accountNumber = scanner.nextInt();

            BankAccount foundAccount = lookForAccount(bankAccounts, accountNumber);

            if (foundAccount != null){

                while(true){
                    System.out.printf("\n" + "Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    if (depositAmount < 0){
                        continue;
                    }

                    foundAccount.deposit(depositAmount);
                    System.out.println("Deposit successful");
                    break;
                }

            }
            else{
                System.out.println("Invalid Account Number!");
                continue;
            }
            break;
        }


    }

    public static void main(String[] args) {

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Check Balance");
        System.out.println("4. Deposit");
        System.out.println("5. Widthdraw");
        System.out.println("6. Exit");

        while (true) {

            System.out.printf("\n" + "Enter Choice (1-6): ");
            int userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    createAccount(bankAccounts);
                    break;
                case 2:
                    viewAccounts(bankAccounts);
                    break;
                case 3:
                    checkBalance(bankAccounts);
                    break;
                case 4:
                    depositToAccount(bankAccounts);
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Thank you!");
                    return;
            }
        }
    }
}