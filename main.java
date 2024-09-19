import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> accounts = new HashMap<>();
        boolean running = true;
        String currentUser = null;

        System.out.println("Welcome to the banking System");


        while (running) {
            if (currentUser == null) {
                System.out.println("/n1. Registered an Account");
                System.out.println("2. Login to Existing Account");
                System.out.println("3. Exit");

                System.out.println("Please choose an option");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1){
                
                    System.out.print("Enter your name");
                    String name = scanner.nextLine();
                    if (accounts.containsKey(name)){
                        System.out.println("An account with this name already exists ");
                        } else{

                        System.out.println("Enter initial deposit");
                        double initialDeposit = scanner.nextDouble();
                        if (initialDeposit >= 0) {
                            accounts.put(name, initialDeposit);
                            System.out.println("Account succesfully created for " + name);
                        } 
                        else {
                            System.out.println("Initial deposit must be a positive account. ");
                        }
                    }  
                } else if (choice == 2) {
                        System.out.println("Enter username");
                        String name = scanner.nextLine();
                        if (accounts.containsKey(name)) {
                            currentUser = name;
                            System.out.println("Welcome" + name);
                        } else {
                            System.out.println("Acount not found");
                        }
                    } else if (choice == 3){

                        System.out.println("Thank you");
                        running = false;
                    } else {
                        System.out.println("Invalid! Please select a valid option");
                    }

            } else {
                System.out.println("/nMenu");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. withdraw");
                System.out.println("4. Logout");

                System.out.println("Please choose an option: ");
                int choice = scanner.nextInt();

                if (choice == 1){
                    System.out.println("Your current balance is: $" + accounts.get(currentUser));
                } else if (choice == 2){
                    System.out.println("Enter the amount to deposit");
                    double depositAmount = scanner.nextDouble();
                    if(depositAmount > 0) {
                        accounts.put(currentUser, accounts.get(currentUser) + depositAmount);
                        System.out.println("Successfully deposited $" + depositAmount);
                        System.out.println("Your new balance is: $ "+ accounts.get(currentUser));
                    } else {
                        System.out.println("Invalid Amount!");
                    }
                }else if ( choice == 3){
                
                    System.out.println("Enter ammount to withdraw");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= accounts.get (currentUser)){
                        accounts.put(currentUser, accounts.get(currentUser) - withdrawAmount);
                        System.out.println("Successfully withdraw $" + withdrawAmount);
                        System.out.println("Your new balance is: $" + accounts.get(currentUser));
                    }else if (withdrawAmount > accounts.get(currentUser)){
                        System.out.println("Insufficient Balance");
                    }else{
                        System.out.println(" Invalid Amount!");
                    }
                

                } else if (choice == 4){
                    System.out.println("Logging out. Thankyou for using  banking system" + currentUser);
                    currentUser = null;
                } else{
                    System.out.println("Invalid choice. please select a valid option");
                }
            }
        }
    }       
}
